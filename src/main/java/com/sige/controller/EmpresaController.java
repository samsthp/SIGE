package com.sige.controller;

import com.sige.model.OfertaEstagio;
import com.sige.service.OfertaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "*")
public class EmpresaController {

    private final OfertaService ofertaService;

    public EmpresaController(OfertaService ofertaService) {
        this.ofertaService = ofertaService;
    }

    // Endpoint para listar ofertas de uma empresa
    @GetMapping("/{empresaId}/ofertas")
    public ResponseEntity<List<OfertaEstagio>> listarOfertasPorEmpresa(@PathVariable Long empresaId) {
        List<OfertaEstagio> ofertas = ofertaService.listarPorEmpresa(empresaId);
        return ResponseEntity.ok(ofertas);
    }
}
