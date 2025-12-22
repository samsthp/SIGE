package com.sige.controller;

import com.sige.model.Aluno;
import com.sige.service.AlunoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno dados) {
        return service.atualizar(id, dados);
    }

    @GetMapping("/api/aluno/teste")
    public String rotaAluno() {
        return "Acesso permitido: ALUNO";
    }

}
