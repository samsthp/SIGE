package com.sige.controller;

import com.sige.model.Candidatura;
import com.sige.model.Coordenador;
import com.sige.service.CoordenadorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coordenador")
@CrossOrigin(origins = "*")
public class CoordenadorController {

    private final CoordenadorService coordenadorService;

    public CoordenadorController(CoordenadorService coordenadorService) {
        this.coordenadorService = coordenadorService;
    }

    // ✅ CADASTRAR COORDENADOR
    @PostMapping("/cadastrar")
    public ResponseEntity<Coordenador> cadastrar(@RequestBody Coordenador coordenador) {
        return ResponseEntity.ok(coordenadorService.cadastrar(coordenador));
    }

    // ✅ Aceitar candidato
    @PostMapping("/{id}/aceitar")
    public ResponseEntity<Candidatura> aceitarCandidato(@PathVariable Long id) {
        return ResponseEntity.ok(coordenadorService.aceitarCandidato(id));
    }

    // ✅ Recusar candidato
    @PostMapping("/{id}/recusar")
    public ResponseEntity<Candidatura> recusarCandidato(@PathVariable Long id) {
        return ResponseEntity.ok(coordenadorService.recusarCandidato(id));
    }

    // (opcional) Ativar candidato aceito
    @PostMapping("/{id}/ativar")
    public ResponseEntity<Candidatura> ativarCandidato(@PathVariable Long id) {
        return ResponseEntity.ok(coordenadorService.ativarCandidato(id));
    }

    // (opcional) Finalizar estágio
    @PostMapping("/{id}/finalizar")
    public ResponseEntity<Candidatura> finalizarCandidato(@PathVariable Long id) {
        return ResponseEntity.ok(coordenadorService.finalizarCandidato(id));
    }

    // ✅ Listar todos candidatos
    @GetMapping("/candidaturas")
    public ResponseEntity<List<Candidatura>> listarTodos() {
        return ResponseEntity.ok(coordenadorService.listarTodos());
    }
}
