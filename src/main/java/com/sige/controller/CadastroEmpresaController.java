package com.sige.controller;

import com.sige.dto.CadastroEmpresaDTO;
import com.sige.model.EnumRole;
import com.sige.model.Usuario;
import com.sige.repository.UsuarioRepository;
import com.sige.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadastro/empresa")
@RequiredArgsConstructor
public class CadastroEmpresaController {

    private final UsuarioRepository usuarioRepository;
    private final EmailService emailService;

    // ========================= GET — formulário =========================
    @GetMapping
    public String mostrarFormulario() {
        return "cadastroempresa.html";
    }

    // ========================= POST — finalizar cadastro =========================
    @PostMapping("/finalizar")
    @ResponseBody
    public String finalizar(@ModelAttribute CadastroEmpresaDTO dto) {

        // 🔒 Verifica CNPJ duplicado
        if (usuarioRepository.findByCnpj(dto.getCnpj()).isPresent()) {
            return "<script>alert('CNPJ já cadastrado!'); window.history.back();</script>";
        }

        // ✅ Cria empresa como USUÁRIO
        Usuario empresa = new Usuario();
        empresa.setNome(dto.getNome());
        empresa.setCnpj(dto.getCnpj());
        empresa.setEmail(dto.getEmail());
        empresa.setSenha(dto.getSenha()); // depois criptografar com BCrypt
        empresa.setTipo("empresa");
        empresa.setRole(EnumRole.EMPRESA);

        usuarioRepository.save(empresa);

        // 📧 Email de boas-vindas
        emailService.enviarEmail(
                empresa.getEmail(),
                "Cadastro concluído",
                "Olá " + empresa.getNome() + ", seu cadastro foi realizado com sucesso!"
        );

        return "<script>alert('Cadastro realizado com sucesso!'); window.location.href='/login.html';</script>";
    }
}
