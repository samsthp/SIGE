package com.sige.controller;

import com.sige.model.Vaga;
import com.sige.repository.VagaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private final VagaRepository vagaRepository;

    public VagaController(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
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
