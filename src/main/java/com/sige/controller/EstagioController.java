package com.sige.controller;

import com.sige.model.Estagio;
import com.sige.model.Usuario;
import com.sige.repository.EstagioRepository;
import com.sige.repository.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estagios")
@CrossOrigin(origins = "*")
public class EstagioController {

    private final EstagioRepository estagioRepository;
    private final UsuarioRepository usuarioRepository;

    public EstagioController(
            EstagioRepository estagioRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.estagioRepository = estagioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/meu")
    public List<Estagio> meuEstagio() {

        String principal = SecurityContextHolder.getContext().getAuthentication().getName();

        Usuario aluno = usuarioRepository.findByPrincipal(principal)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return estagioRepository.findByAlunoIdAndStatus(aluno.getId(), "ATIVO");
    }
}
