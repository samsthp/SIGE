package com.sige.service;

<<<<<<< HEAD
import com.sige.dto.LoginRequest;
import com.sige.model.EnumRole;
import com.sige.model.Usuario;
import com.sige.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // ========================= LOGIN =========================
    public Map<String, String> login(LoginRequest request) {

        String identificador = request.getIdentificador();
        String senhaDigitada = request.getSenha();
        String tipo = request.getTipo();

        if (identificador == null || senhaDigitada == null || tipo == null) {
            return Map.of(
                    "status", "error",
                    "message", "Preencha todos os campos!"
            );
        }

        Usuario usuario = switch (tipo.toLowerCase()) {
            case "aluno" -> {
                List<Usuario> lista = usuarioRepository.findByMatricula(identificador);
                yield lista.isEmpty() ? null : lista.get(0);
            }
            case "empresa" -> {
                List<Usuario> lista = usuarioRepository.findByCnpj(identificador);
                yield lista.isEmpty() ? null : lista.get(0);
            }
            case "coordenador" -> {
                List<Usuario> lista = usuarioRepository.findByCpf(identificador);
                yield lista.isEmpty() ? null : lista.get(0);
            }
            default -> null;
        };

        if (usuario == null) {
            return Map.of(
                    "status", "error",
                    "message", "Usuário não encontrado!"
            );
        }

        // LOGS DE DEPURAÇÃO
        System.out.println("Senha digitada: " + senhaDigitada);
        System.out.println("Senha no banco: " + usuario.getSenha());

        // Comparação segura (evita NullPointerException)
        if (usuario.getSenha() == null || !senhaDigitada.equals(usuario.getSenha())) {
            return Map.of(
                    "status", "error",
                    "message", "Senha incorreta!"
            );
        }

        return Map.of(
                "status", "success",
                "message", "Login bem-sucedido!",
                "tipo", usuario.getTipo()
        );
    }

    // ========================= REGISTRO =========================
    public String registerUser(Usuario usuario) {
        try {
            if (usuario.getTipo() == null || usuario.getSenha() == null || usuario.getSenha().isBlank()) {
                return "Erro: tipo e senha são obrigatórios!";
            }

            String tipo = usuario.getTipo().toLowerCase();

            switch (tipo) {
                case "empresa" -> {
                    if (usuario.getCnpj() == null || usuario.getCnpj().isBlank()) {
                        return "Erro: CNPJ é obrigatório para empresas!";
                    }
                }
                case "aluno" -> {
                    if (usuario.getCpf() == null || usuario.getCpf().isBlank()) {
                        return "Erro: CPF é obrigatório para alunos!";
                    }
                    if (usuario.getMatricula() == null || usuario.getMatricula().isBlank()) {
                        usuario.setMatricula("A" + System.currentTimeMillis());
                    }
                }
                case "coordenador" -> {
                    if (usuario.getCpf() == null || usuario.getCpf().isBlank()) {
                        return "Erro: CPF é obrigatório para coordenadores!";
                    }
                }
                default -> {
                    return "Erro: tipo de usuário inválido!";
                }
            }

            EnumRole role = switch (tipo) {
                case "aluno" -> EnumRole.ALUNO;
                case "empresa" -> EnumRole.EMPRESA;
                case "coordenador" -> EnumRole.COORDENADOR;
                default -> EnumRole.ALUNO;
            };

            usuario.setRole(role);
            usuario.setTipo(tipo);

            // Senha em texto puro (sem encoder)
            usuarioRepository.save(usuario);

            return "Usuário cadastrado com sucesso!";

        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            return "Erro: já existe um usuário com esses dados no sistema!";
        } catch (Exception e) {
            return "Erro inesperado ao registrar usuário: " + e.getMessage();
        }
    }
}

