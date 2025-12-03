package com.sige.controller;

import com.sige.model.Vaga;
import com.sige.service.VagaService;
import com.sige.repository.VagaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vagas")
@CrossOrigin(origins = "*")
public class VagaController {

    private final VagaService vagaService;
    private final VagaRepository vagaRepository;


    public VagaController(VagaService vagaService, VagaRepository vagaRepository) {
        this.vagaService = vagaService;
        this.vagaRepository = vagaRepository;
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

    @PostMapping("/publicar")
    public String publicarVaga(@RequestBody Vaga vaga) {
        vagaRepository.save(vaga);
        return "Vaga publicada com sucesso!";
    }

    @GetMapping("/listar")
    public List<Vaga> listarVagas() {
        return vagaRepository.findAll();
    }
}
