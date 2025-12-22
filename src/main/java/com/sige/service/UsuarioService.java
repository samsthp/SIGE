package com.sige.service;

import com.sige.model.Usuario;
import com.sige.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Salvar ou atualizar um usuário
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Buscar usuário por ID
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Buscar usuário por CPF
    public Usuario buscarPorCpf(String cpf) {
        List<Usuario> usuarios = usuarioRepository.findByCpf(cpf);
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }

    // Buscar usuário por matrícula
    public Usuario buscarPorMatricula(String matricula) {
        List<Usuario> usuarios = usuarioRepository.findByMatricula(matricula);
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }

    // Buscar usuário por CNPJ
    public Usuario buscarPorCnpj(String cnpj) {
        List<Usuario> usuarios = usuarioRepository.findByCnpj(cnpj);
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }

    // Listar todos os usuários
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Deletar usuário por ID
    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}