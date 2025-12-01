package com.sige.controller;

import com.sige.model.Candidatura;
import com.sige.service.EmpresaService;
import com.sige.service.CoordenadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/candidatos") // adiciona /api para bater com o front
@CrossOrigin(origins = "*")
public class CandidatoController {

    private final CoordenadorService coordenadorService;

    private final EmpresaService empresaService;

    public CandidatoController(EmpresaService empresaService, CoordenadorService coordenadorService) {
        this.empresaService = empresaService;
        this.coordenadorService = coordenadorService;
    }

    @PostMapping("/{id}/aceitar")
    public ResponseEntity<Candidatura> aceitarCandidato(@PathVariable Long id) {
        Candidatura c = empresaService.aceitarCandidato(id);
        return ResponseEntity.ok(c);
    }

    @PostMapping("/{id}/recusar")
    public ResponseEntity<Candidatura> recusarCandidato(@PathVariable Long id) {
        Candidatura c = empresaService.recusarCandidato(id);
        return ResponseEntity.ok(c);
    }

    @PostMapping("/{id}/finalizar")
    public ResponseEntity<Candidatura> finalizarCandidato(@PathVariable Long id) {
        return ResponseEntity.ok(coordenadorService.finalizarCandidato(id));
    }

    @GetMapping("/oferta/{ofertaId}")
    public ResponseEntity<List<Candidatura>> listarCandidatosPorOferta(@PathVariable Long ofertaId) {
        return ResponseEntity.ok(empresaService.listarCandidatosPorOferta(ofertaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidatura> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.of(empresaService.buscarPorId(id));
    }

}
