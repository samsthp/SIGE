package com.sige.controller;

import com.sige.model.OfertaEstagio;
import com.sige.service.OfertaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sige.model.Candidatura;
import java.util.List;

@RestController
@RequestMapping("/api/ofertas")
@CrossOrigin(origins = "*")
public class OfertaController {

    private final OfertaService ofertaService;

    public OfertaController(OfertaService ofertaService) {
        this.ofertaService = ofertaService;
    }

    @PostMapping
    public ResponseEntity<OfertaEstagio> criar(@RequestBody OfertaEstagio oferta) {
        return ResponseEntity.ok(ofertaService.criar(oferta));
    }

    @GetMapping
    public List<OfertaEstagio> listarTodas() {
        return ofertaService.listarTodas();
    }
}

