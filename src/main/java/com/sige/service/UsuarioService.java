package com.sige.service;

import com.sige.model.Usuario;
import com.sige.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Salvar ou atualizar
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Buscar por ID
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // ✅ CPF
    public Usuario buscarPorCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf).orElse(null);
    }

    // ✅ Matrícula
    public Usuario buscarPorMatricula(String matricula) {
        return usuarioRepository.findByMatricula(matricula).orElse(null);
    }

    // ✅ CNPJ
    public Usuario buscarPorCnpj(String cnpj) {
        return usuarioRepository.findByCnpj(cnpj).orElse(null);
    }

    // Listar todos
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Deletar
    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}
