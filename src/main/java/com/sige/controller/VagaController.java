package com.sige.controller;

import com.sige.model.Vaga;
import com.sige.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vagas")
@CrossOrigin(origins = "*")

public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping
    public List<Vaga> listarTodas() {
        return vagaService.listarTodas();

    }

    @GetMapping("/curso")
    public List<Vaga> buscarPorCurso(@RequestParam String curso) {
        return vagaService.buscarPorCurso(curso);

    @GetMapping("/estado")
    public List<Vaga> buscarPorEstado(@RequestParam String estado) {
        return vagaService.buscarPorEstado(estado);
    }

    @PostMapping
    public Vaga cadastrar(@RequestBody Vaga vaga) {
        return vagaService.salvar(vaga);
    }

}
