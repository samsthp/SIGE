package com.sige.controller;

import com.sige.dto.CadastroAlunoDTO;
import com.sige.service.AlunoService;
import com.sige.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cadastro/aluno")
public class CadastroAlunoController {

    private final AlunoService service;
    private final EmailService emailService;

    public CadastroAlunoController(AlunoService service, EmailService emailService) {
        this.service = service;
        this.emailService = emailService;
    }

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("dto", new CadastroAlunoDTO());
        return "cadastroaluno";
    }

    @PostMapping("/finalizar")
    public String finalizar(@Valid @ModelAttribute("dto") CadastroAlunoDTO dto,
                            BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if(result.hasErrors()) {
            return "cadastroaluno"; // volta pro formulário se houver erro
        }

        if(service.existsByCpf(dto.getCpf())) {
            model.addAttribute("erroCpf", "CPF já cadastrado!");
            return "cadastroaluno";
        }

        service.salvar(dto);

        // envia email
        emailService.enviarEmail(dto.getEmail(), "Cadastro concluído",
                "Olá " + dto.getNome() + ", seu cadastro foi realizado com sucesso!");

        // mensagem de sucesso
        redirectAttributes.addFlashAttribute("mensagemSucesso",
                "Cadastro realizado com sucesso! Verifique seu e-mail.");

        return "redirect:/login.html";
    }
}
