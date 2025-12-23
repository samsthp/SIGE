package com.sige.controller;

import com.sige.dto.CandidaturaResponseDTO;
import com.sige.model.*;
import com.sige.repository.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/candidaturas")
@CrossOrigin(origins = "*")
public class CandidaturaController {

    private final UsuarioRepository usuarioRepository;
    private final VagaRepository vagaRepository;
    private final CandidaturaRepository candidaturaRepository;
    private final EstagioRepository estagioRepository;

    public CandidaturaController(
            UsuarioRepository usuarioRepository,
            VagaRepository vagaRepository,
            CandidaturaRepository candidaturaRepository,
            EstagioRepository estagioRepository
    ) {
        this.usuarioRepository = usuarioRepository;
        this.vagaRepository = vagaRepository;
        this.candidaturaRepository = candidaturaRepository;
        this.estagioRepository = estagioRepository;
    }

    // 1️⃣ ALUNO SE CANDIDATA
    @PostMapping
    public Map<String, Object> candidatar(@RequestBody Map<String, String> body) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String principal = auth.getName();

        Usuario aluno = usuarioRepository.findByPrincipal(principal)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        if (aluno.getRole() != EnumRole.ALUNO) {
            return Map.of("status", "error", "message", "Usuário não é aluno");
        }

        Long vagaId = Long.valueOf(body.get("vagaId"));
        Vaga vaga = vagaRepository.findById(vagaId)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

        boolean jaCandidatado = candidaturaRepository
                .findByAlunoId(aluno.getId())
                .stream()
                .anyMatch(c -> c.getVaga().getId().equals(vagaId));

        if (jaCandidatado) {
            return Map.of("status", "error", "message", "Você já se candidatou");
        }

        Candidatura candidatura = new Candidatura();
        candidatura.setAluno(aluno);
        candidatura.setVaga(vaga);
        candidatura.setStatus(StatusCandidatura.INSCRITO); // 🔥 AQUI

        candidaturaRepository.save(candidatura);

        return Map.of("status", "success", "message", "Candidatura realizada");
    }

    // 2️⃣ ALUNO — MINHAS CANDIDATURAS
    @GetMapping("/minhas")
    public List<CandidaturaResponseDTO> minhasCandidaturas() {

        String principal = SecurityContextHolder.getContext().getAuthentication().getName();

        Usuario aluno = usuarioRepository.findByPrincipal(principal)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return candidaturaRepository.findByAlunoId(aluno.getId())
                .stream()
                .map(CandidaturaResponseDTO::new)
                .toList();
    }

    // 3️⃣ EMPRESA — LISTAR POR VAGA
    @GetMapping("/vaga/{vagaId}")
    public List<CandidaturaResponseDTO> listarPorVaga(@PathVariable Long vagaId) {

        return candidaturaRepository.findByVagaId(vagaId)
                .stream()
                .map(CandidaturaResponseDTO::new)
                .toList();
    }

    // 4️⃣ EMPRESA ACEITA → CRIA ESTÁGIO
    @PostMapping("/aceitar/{id}")
    public Map<String, Object> aceitar(@PathVariable Long id) {

        Candidatura candidatura = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));

        Estagio estagio = new Estagio();
        estagio.setAluno(candidatura.getAluno());
        estagio.setEmpresa(candidatura.getVaga().getEmpresa());
        estagio.setVaga(candidatura.getVaga());
        estagio.setStatus("ATIVO"); // Estagio ainda é String, OK

        estagioRepository.save(estagio);

        candidatura.setStatus(StatusCandidatura.ATIVO);
        candidaturaRepository.save(candidatura);

        return Map.of("status", "success", "message", "Estágio criado");
    }

    // 5️⃣ EMPRESA RECUSA
    @PostMapping("/recusar/{id}")
    public Map<String, Object> recusar(@PathVariable Long id) {

        Candidatura candidatura = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));

        candidatura.setStatus(StatusCandidatura.RECUSADA);
        candidaturaRepository.save(candidatura);

        return Map.of("status", "success", "message", "Candidatura recusada");
    }
}
