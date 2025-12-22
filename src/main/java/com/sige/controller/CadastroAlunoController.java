package com.sige.controller;

<<<<<<< HEAD
import com.sige.dto.CadastroAlunoDTO;
import com.sige.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cadastro/aluno")
public class CadastroAlunoController {

    private final AlunoService service;

    public CadastroAlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public String mostrarFormulario() {
        return "redirect:/cadastroaluno.html";
    }

    @PostMapping("/finalizar")
    public String finalizar(@Valid @ModelAttribute("dto") CadastroAlunoDTO dto,
                            BindingResult result,
                            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "redirect:/cadastroaluno.html?error=validation";
        }

        try {
            service.salvar(dto);
        } catch (RuntimeException e) {
            return "redirect:/cadastroaluno.html?error=cpf";
        }

        // Removeu envio de email
        redirectAttributes.addFlashAttribute("mensagemSucesso",
                "Cadastro realizado com sucesso!");
        return "redirect:/login.html?success=true";
    }
}

