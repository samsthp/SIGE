package com.sige.service;

import com.sige.model.Denuncia;
import com.sige.model.Estagio;
import com.sige.model.Usuario;
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

    /* ==========================
       ALUNO — CRIAR DENÚNCIA
    ========================== */
    public Denuncia criarDenuncia(Usuario aluno, Long estagioId, String descricao) {

        Estagio estagio = estagioRepository.findById(estagioId)
                .orElseThrow(() -> new RuntimeException("Estágio não encontrado"));

        Denuncia denuncia = new Denuncia();
        denuncia.setAluno(aluno);
        denuncia.setEstagio(estagio);
        denuncia.setDescricao(descricao);
        denuncia.setStatus("PENDENTE"); // 🔥 OBRIGATÓRIO

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
       COORDENADOR — REMOVER
    ========================== */
    public void removerDoEstagio(Long denunciaId) {

        Denuncia denuncia = denunciaRepository.findById(denunciaId)
                .orElseThrow(() -> new RuntimeException("Denúncia não encontrada"));

        Estagio estagio = denuncia.getEstagio();
        estagio.setStatus("CANCELADO");

        denuncia.setStatus("REMOVIDO");

        estagioRepository.save(estagio);
        denunciaRepository.save(denuncia);
    }
}
