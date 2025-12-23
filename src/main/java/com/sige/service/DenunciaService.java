package com.sige.service;

import com.sige.model.Candidatura;
import com.sige.model.Denuncia;
import com.sige.model.Estagio;
import com.sige.model.StatusCandidatura;
import com.sige.repository.CandidaturaRepository;
import com.sige.repository.DenunciaRepository;
import com.sige.repository.EstagioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DenunciaService {

    private final DenunciaRepository denunciaRepository;
    private final EstagioRepository estagioRepository;
    private final CandidaturaRepository candidaturaRepository;

    /* ==========================
       ALUNO — CRIAR DENÚNCIA
    ========================== */
    public Denuncia criarDenuncia(
            com.sige.model.Usuario aluno,
            Long estagioId,
            String descricao
    ) {
        Estagio estagio = estagioRepository.findById(estagioId)
                .orElseThrow(() -> new RuntimeException("Estágio não encontrado"));

        Denuncia denuncia = new Denuncia();
        denuncia.setAluno(aluno);
        denuncia.setEstagio(estagio);
        denuncia.setDescricao(descricao);
        denuncia.setStatus("PENDENTE");

        return denunciaRepository.save(denuncia);
    }

    /* ==========================
       COORDENADOR — LISTAR
    ========================== */
    public List<Denuncia> listarPendentes() {
        return denunciaRepository.findByStatus("PENDENTE");
    }

    /* ==========================
       COORDENADOR — MANTER
    ========================== */
    public void manterNoEstagio(Long denunciaId) {
        Denuncia denuncia = denunciaRepository.findById(denunciaId)
                .orElseThrow(() -> new RuntimeException("Denúncia não encontrada"));

        denuncia.setStatus("MANTIDO");
        denunciaRepository.save(denuncia);
    }

    /* ==========================
       COORDENADOR — REMOVER (CORRETO)
    ========================== */
    public void removerDoEstagio(Long denunciaId) {

        Denuncia denuncia = denunciaRepository.findById(denunciaId)
                .orElseThrow(() -> new RuntimeException("Denúncia não encontrada"));

        Estagio estagio = denuncia.getEstagio();

        // 1️⃣ Cancela o estágio
        estagio.setStatus("CANCELADO");
        estagioRepository.save(estagio);

        // 2️⃣ Cancela a candidatura ativa do aluno naquela vaga
        candidaturaRepository
                .findByAlunoIdAndVagaIdAndStatus(
                        estagio.getAluno().getId(),
                        estagio.getVaga().getId(),
                        StatusCandidatura.ATIVO
                )
                .ifPresent(c -> {
                    c.setStatus(StatusCandidatura.CANCELADA);
                    candidaturaRepository.save(c);
                });

        // 3️⃣ Finaliza a denúncia
        denuncia.setStatus("REMOVIDO");
        denunciaRepository.save(denuncia);
    }
}
