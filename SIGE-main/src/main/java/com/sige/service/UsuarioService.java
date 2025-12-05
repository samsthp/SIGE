package com.sige.service;

import com.sige.model.Usuario;
import com.sige.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }


    public Usuario atualizarPerfil(Long id, Usuario dados) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dados.getNome());
        usuario.setEmail(dados.getEmail());
        usuario.setEndereco(dados.getEndereco());

        if (dados.getSenha() != null && !dados.getSenha().isBlank()) {
            usuario.setSenha(dados.getSenha());
        }

        return repository.save(usuario);
    }
}
