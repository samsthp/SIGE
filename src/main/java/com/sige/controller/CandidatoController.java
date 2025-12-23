package com.sige.controller;

import com.sige.model.Candidatura;
import com.sige.service.CandidaturaService;
import com.sige.service.CoordenadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatos")
@CrossOrigin(origins = "*")
public class CandidatoController {

    private final CandidaturaService candidaturaService;
    private final CoordenadorService coordenadorService;

    public CandidatoController(
            CandidaturaService candidaturaService,
            CoordenadorService coordenadorService
    ) {
        this.candidaturaService = candidaturaService;
        this.coordenadorService = coordenadorService;
    }

    // =========================
    // ACEITAR CANDIDATO
    // =========================
    @PostMapping("/{id}/aceitar")
    public ResponseEntity<Candidatura> aceitarCandidato(@PathVariable Long id) {
        return ResponseEntity.ok(candidaturaService.aceitarCandidato(id));
    }

    // =========================
    // RECUSAR CANDIDATO
    // =========================
    @PostMapping("/{id}/recusar")
    public ResponseEntity<Candidatura> recusarCandidato(@PathVariable Long id) {
        return ResponseEntity.ok(candidaturaService.recusarCandidato(id));
    }

    // =========================
    // FINALIZAR (COORDENADOR)
    // =========================
    @PostMapping("/{id}/finalizar")
    public ResponseEntity<Candidatura> finalizarCandidato(@PathVariable Long id) {
        return ResponseEntity.ok(coordenadorService.finalizarCandidato(id));
    }

    // =========================
    // LISTAR POR OFERTA
    // =========================
    @GetMapping("/oferta/{ofertaId}")
    public ResponseEntity<List<Candidatura>> listarCandidatosPorOferta(
            @PathVariable Long ofertaId
    ) {
        return ResponseEntity.ok(candidaturaService.listarPorOferta(ofertaId));
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<Candidatura> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.of(candidaturaService.buscarPorId(id));
    }
}
