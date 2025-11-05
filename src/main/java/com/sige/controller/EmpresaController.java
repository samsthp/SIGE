package com.sige.controller;

import com.sige.model.Candidatura;
import com.sige.service.EmpresaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "*")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/oferta/{ofertaId}/candidatos")
    public List<Candidatura> listarCandidatos(@PathVariable Long ofertaId) {
        return empresaService.listarCandidatosPorOferta(ofertaId);
    }

    @PostMapping("/candidatura/{id}/aceitar")
    public void aceitarCandidato(@PathVariable Long id) {
        empresaService.aceitarCandidato(id);
    }

    @PostMapping("/candidatura/{id}/recusar")
    public void recusarCandidato(@PathVariable Long id) {
        empresaService.recusarCandidato(id);
    }
}
