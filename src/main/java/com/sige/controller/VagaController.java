package com.sige.controller;

import com.sige.model.Vaga;
import com.sige.service.VagaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
@CrossOrigin(origins = "*")
public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @GetMapping
    public List<Vaga> listarTodas() {
        return vagaService.listarTodas();
    }

    @GetMapping("/curso/{curso}")
    public List<Vaga> buscarPorCurso(@PathVariable String curso) {
        return vagaService.buscarPorCurso(curso);
    }

    @GetMapping("/estado/{estado}")
    public List<Vaga> buscarPorEstado(@PathVariable String estado) {
        return vagaService.buscarPorEstado(estado);
    }

    @GetMapping("/empresa/{empresa}")
    public List<Vaga> buscarPorEmpresa(@PathVariable String empresa) {
        return vagaService.buscarPorEmpresa(empresa);
    }
}
