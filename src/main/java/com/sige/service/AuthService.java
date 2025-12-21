package com.sige.service;

import com.sige.dto.LoginRequest;
import com.sige.model.EnumRole;
import com.sige.model.ResetCode;
import com.sige.model.Usuario;
import com.sige.config.JwtUtil;
import com.sige.repository.ResetCodeRepository;
import com.sige.repository.UsuarioRepository;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ResetCodeRepository resetCodeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    // ==============================================
    //                  LOGIN
    // ==============================================
    public Map<String, Object> login(LoginRequest request) {

        if (request.getIdentificador() == null ||
                request.getSenha() == null ||
                request.getTipo() == null) {
            return Map.of(
                    "status", "error",
                    "message", "Preencha todos os campos!"
            );
        }

        Usuario usuario = switch (request.getTipo().toLowerCase()) {
            case "aluno" ->
                    usuarioRepository.findByMatricula(
                            request.getIdentificador()
                    ).orElse(null);

            case "empresa" ->
                    usuarioRepository.findByCnpj(
                            request.getIdentificador()
                    ).orElse(null);

            case "coordenador" ->
                    usuarioRepository.findByCpf(
                            request.getIdentificador()
                    ).orElse(null);

            default -> null;
        };

        if (usuario == null) {
            return Map.of(
                    "status", "error",
                    "message", "Usuário não encontrado!"
            );
        }

        if (!passwordEncoder.matches(request.getSenha(), usuario.getSenha())) {
            return Map.of(
                    "status", "error",
                    "message", "Senha incorreta!"
            );
        }

        // 🔐 GERA O TOKEN JWT
        String token = JwtUtil.generateToken(usuario);

        return Map.of(
                "status", "success",
                "message", "Login bem-sucedido!",
                "token", token,
                "tipo", usuario.getTipo()
        );
    }


    // ==============================================
    //                  REGISTRO
    // ==============================================
    public Map<String, Object> registerUser(Usuario usuario) {
        try {
            if (usuario.getTipo() == null ||
                    usuario.getSenha() == null ||
                    usuario.getSenha().isBlank()) {
                return Map.of("status", "error", "message", "Tipo e senha são obrigatórios!");
            }

            String tipo = usuario.getTipo().toLowerCase();

            switch (tipo) {
                case "empresa" -> {
                    if (usuario.getCnpj() == null || usuario.getCnpj().isBlank())
                        return Map.of("status", "error", "message", "CNPJ obrigatório!");
                }
                case "aluno" -> {
                    if (usuario.getCpf() == null || usuario.getCpf().isBlank())
                        return Map.of("status", "error", "message", "CPF obrigatório!");
                    if (usuario.getMatricula() == null || usuario.getMatricula().isBlank())
                        usuario.setMatricula("A" + System.currentTimeMillis());
                }
                case "coordenador" -> {
                    if (usuario.getCpf() == null || usuario.getCpf().isBlank())
                        return Map.of("status", "error", "message", "CPF obrigatório!");
                }
                default -> {
                    return Map.of("status", "error", "message", "Tipo inválido!");
                }
            }

            usuario.setRole(
                    switch (tipo) {
                        case "aluno" -> EnumRole.ALUNO;
                        case "empresa" -> EnumRole.EMPRESA;
                        case "coordenador" -> EnumRole.COORDENADOR;
                        default -> EnumRole.ALUNO;
                    }
            );

            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            usuarioRepository.save(usuario);

            return Map.of("status", "success", "message", "Usuário cadastrado com sucesso!");

        } catch (Exception e) {
            return Map.of("status", "error", "message", "Erro inesperado: " + e.getMessage());
        }
    }

    // ==============================================
    //           ESQUECI MINHA SENHA
    // ==============================================
    public Map<String, Object> enviarCodigo(String email) {

        Optional<Usuario> userOpt = usuarioRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            return Map.of("status", "error", "message", "E-mail não cadastrado!");
        }

        // invalida códigos antigos
        resetCodeRepository.findAllByEmailAndUsadoFalse(email)
                .forEach(rc -> {
                    rc.setUsado(true);
                    resetCodeRepository.save(rc);
                });

        String codigo = String.valueOf((int) (Math.random() * 900000) + 100000);

        ResetCode rc = new ResetCode();
        rc.setEmail(email);
        rc.setCodigo(codigo);
        rc.setExpiration(LocalDateTime.now().plusMinutes(10));
        rc.setUsado(false);

        resetCodeRepository.save(rc);
        enviarEmail(email, codigo);

        return Map.of("status", "success", "message", "Código enviado para seu e-mail!");
    }

    public Map<String, Object> validarCodigo(String email, String codigo) {

        Optional<ResetCode> rcOpt =
                resetCodeRepository.findByEmailAndCodigoAndUsadoFalse(email, codigo);

        if (rcOpt.isEmpty()) {
            return Map.of("status", "error", "message", "Código inválido!");
        }

        if (rcOpt.get().getExpiration().isBefore(LocalDateTime.now())) {
            return Map.of("status", "error", "message", "Código expirado!");
        }

        return Map.of("status", "success", "message", "Código válido!");
    }

    // ==============================================
    //            RESETAR SENHA (FIX REAL)
    // ==============================================
    @Transactional
    public Map<String, Object> resetarSenha(String email, String novaSenha, String codigo) {

        Usuario user = usuarioRepository.findByEmail(email).orElse(null);
        if (user == null) {
            return Map.of("status", "error", "message", "Usuário não encontrado!");
        }

        ResetCode rc = resetCodeRepository
                .findByEmailAndCodigoAndUsadoFalse(email, codigo)
                .orElse(null);

        if (rc == null) {
            return Map.of("status", "error", "message", "Código inválido!");
        }

        if (rc.getExpiration().isBefore(LocalDateTime.now())) {
            return Map.of("status", "error", "message", "Código expirado!");
        }

        if (passwordEncoder.matches(novaSenha, user.getSenha())) {
            return Map.of("status", "error", "message", "A nova senha não pode ser igual à atual!");
        }

        String novaSenhaHash = passwordEncoder.encode(novaSenha);

        int linhas = usuarioRepository.atualizarSenha(email, novaSenhaHash);

        if (linhas == 0) {
            return Map.of("status", "error", "message", "Falha ao atualizar a senha!");
        }

        rc.setUsado(true);
        resetCodeRepository.save(rc);

        return Map.of(
                "status", "success",
                "message", "Senha redefinida com sucesso!"
        );
    }

    // ==============================================
    //              ENVIO DE EMAIL
    // ==============================================
    private void enviarEmail(String to, String codigo) {
        try {
            MimeMessage mime = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mime, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject("SIGE - Recuperação de Senha");

            String html = """
               <html>
               <body style="font-family:Arial; background:#f8fafc; padding:20px">
                   <div style="max-width:480px;margin:auto;background:white;
                       padding:24px;border-radius:12px;border:1px solid #e5e7eb">
                       <h1 style="text-align:center;color:#3b82f6">SIGE</h1>
                       <p>Seu código de recuperação:</p>
                       <div style="font-size:32px;text-align:center;
                           letter-spacing:4px;font-weight:bold">%s</div>
                       <p>Válido por 10 minutos.</p>
                   </div>
               </body>
               </html>
           """.formatted(codigo);

            helper.setText(html, true);
            mailSender.send(mime);

        } catch (Exception e) {
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
        }
    }
}
