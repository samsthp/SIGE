package com.sige.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessaoController {

    @GetMapping("/sessao")
    public Object verificarSessao(Authentication authentication) {

        if (authentication == null) {
            return "Usuário não autenticado";
        }

        return authentication;
    }
}
