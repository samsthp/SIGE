package com.sige.service;

import com.sige.dto.LoginRequest;
import com.sige.model.EnumRole;
import com.sige.model.Usuario;
import com.sige.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ========================= LOGIN =========================
    public Map<String, String> login(LoginRequest request) {
        String identificador = request.getIdentificador();
        String senha = request.getSenha();
        String tipo = request.getTipo();

        if (identificador == null || senha == null || tipo == null)
            return Map.of("status", "error", "message", "Preencha todos os campos!");

        Usuario usuario = switch (tipo.toLowerCase()) {
            case "aluno" -> usuarioRepository.findByMatricula(identificador).orElse(null);
            case "empresa" -> usuarioRepository.findByCnpj(identificador).orElse(null);
            case "coordenador" -> usuarioRepository.findByCpf(identificador).orElse(null);
            default -> null;
        };

        if (usuario == null)
            return Map.of("status", "error", "message", "Usuário não encontrado!");

        if (!passwordEncoder.matches(senha, usuario.getSenha()))
            return Map.of("status", "error", "message", "Senha incorreta!");

        return Map.of(
                "status", "success",
                "message", "Login bem-sucedido!",
                "tipo", tipo.toLowerCase()
        );
    }

    // ========================= REGISTRO =========================
    public String registerUser(Usuario usuario) {
        try {
            // === Validação de campos obrigatórios ===
            if (usuario.getTipo() == null || usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
                return "Erro: tipo e senha são obrigatórios!";
            }

            String tipo = usuario.getTipo().toLowerCase();

            // === Validações específicas por tipo ===
            switch (tipo) {
                case "empresa" -> {
                    if (usuario.getCnpj() == null || usuario.getCnpj().isBlank())
                        return "Erro: CNPJ é obrigatório para empresas!";
                }
                case "aluno" -> {
                    if (usuario.getCpf() == null || usuario.getCpf().isBlank())
                        return "Erro: CPF é obrigatório para alunos!";
                    if (usuario.getMatricula() == null || usuario.getMatricula().isBlank()) {
                        // gera matrícula automática se não houver
                        usuario.setMatricula("A" + System.currentTimeMillis());
                    }
                }
                case "coordenador" -> {
                    if (usuario.getCpf() == null || usuario.getCpf().isBlank())
                        return "Erro: CPF é obrigatório para coordenadores!";
                }
                default -> {
                    return "Erro: tipo de usuário inválido!";
                }
            }

            // === Define o papel (role) ===
            usuario.setRole(switch (tipo) {
                case "aluno" -> EnumRole.ALUNO;
                case "empresa" -> EnumRole.EMPRESA;
                case "coordenador" -> EnumRole.COORDENADOR;
                default -> EnumRole.ALUNO;
            });

            // === Codifica a senha ===
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

            // === Salva no banco ===
            usuarioRepository.save(usuario);

            return "Usuário cadastrado com sucesso!";

        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            // Erros de violação de chave única (CPF, CNPJ, matrícula, e-mail, etc.)
            return "Erro: já existe um usuário com esses dados no sistema!";
        } catch (jakarta.persistence.PersistenceException e) {
            // Problemas na camada JPA (erro SQL, constraint, etc.)
            return "Erro ao salvar no banco de dados: " + e.getMessage();
        } catch (Exception e) {
            // Erros genéricos (null, validação, etc.)
            return "Erro inesperado ao registrar usuário: " + e.getMessage();
        }
    }
}
