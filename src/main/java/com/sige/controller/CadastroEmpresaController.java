package com.sige.controller;

import com.sige.dto.CadastroEmpresaDTO;
import com.sige.service.EmpresaService;
import com.sige.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadastro/empresa")
public class CadastroEmpresaController {

    private final EmpresaService service;
    private final EmailService emailService;

    public CadastroEmpresaController(EmpresaService service, EmailService emailService) {
        this.service = service;
        this.emailService = emailService;
    }

    // GET: mostra o formulário de cadastro (HTML estático)
    @GetMapping
    public String mostrarFormulario() {
        return "cadastroempresa.html"; // HTML estático na pasta /static
    }

    // POST: finaliza o cadastro
    @PostMapping("/finalizar")
    @ResponseBody
    public String finalizar(@ModelAttribute CadastroEmpresaDTO dto) {

        // Verifica CNPJ duplicado
        if(service.existsByCnpj(dto.getCnpj())) {
            return "<script>alert('CNPJ já cadastrado!'); window.history.back();</script>";
        }

        // Salva a empresa
        service.salvar(dto);

        // Envia email de boas-vindas
        emailService.enviarEmail(dto.getEmail(), "Cadastro concluído",
                "Olá " + dto.getNome() + ", seu cadastro foi realizado com sucesso!");

        // Retorna script para mostrar mensagem e redirecionar para login.html
        return "<script>alert('Cadastro realizado com sucesso! Verifique seu e-mail.'); window.location.href='/login.html';</script>";
    }
}
