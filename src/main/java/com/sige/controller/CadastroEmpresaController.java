package com.sige.controller;

<<<<<<< HEAD
import com.sige.dto.CadastroEmpresaDTO;
import com.sige.service.EmpresaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadastro/empresa")
public class CadastroEmpresaController {

    private final EmpresaService service;

    public CadastroEmpresaController(EmpresaService service) {
        this.service = service;
    }

    @GetMapping
    public String mostrarFormulario() {
        return "cadastroempresa.html";
    }

    @PostMapping("/finalizar")
    @ResponseBody
    public String finalizar(@ModelAttribute CadastroEmpresaDTO dto) {

        if(service.existsByCnpj(dto.getCnpj())) {
            return "<script>alert('CNPJ já cadastrado!'); window.history.back();</script>";
        }

        service.salvar(dto);

        // Removeu envio de email
        return "<script>alert('Cadastro realizado com sucesso!'); window.location.href='/login.html';</script>";
    }
}

