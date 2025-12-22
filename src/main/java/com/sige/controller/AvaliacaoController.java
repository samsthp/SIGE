package com.sige.controller;

import com.sige.dto.AvaliacaoDTO;
import com.sige.model.Avaliacao;
import com.sige.model.Aluno;
import com.sige.model.Empresa;
import com.sige.service.AvaliacaoService;
import com.sige.repository.AlunoRepository;
import com.sige.repository.EmpresaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
@CrossOrigin(origins = "*")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;
    private final AlunoRepository alunoRepo;
    private final EmpresaRepository empresaRepo;

    public AvaliacaoController(AvaliacaoService avaliacaoService, AlunoRepository alunoRepo, EmpresaRepository empresaRepo) {
        this.avaliacaoService = avaliacaoService;
        this.alunoRepo = alunoRepo;
        this.empresaRepo = empresaRepo;
    }

    @PostMapping
    public Avaliacao criar(@RequestBody AvaliacaoDTO dto) {

        Aluno aluno = alunoRepo.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Empresa empresa = empresaRepo.findById(dto.getEmpresaId())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota(dto.getNota());
        avaliacao.setDescricao(dto.getDescricao());
        avaliacao.setAluno(aluno);
        avaliacao.setEmpresa(empresa);

        return avaliacaoService.salvar(avaliacao);
    }

    @GetMapping
    public List<Avaliacao> listar() {
        return avaliacaoService.listar();
    }
}
