package com.sige.controller;

<<<<<<< HEAD
import com.sige.dto.LoginRequest;
import com.sige.model.Usuario;
import com.sige.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        try {
            return authService.login(request);
        } catch (Exception e) {
            e.printStackTrace(); // 👈 mostra o erro completo no console
            return Map.of(
                "status", "error",
                "message", "Erro interno: " + e.getMessage()
            );
        }
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody Usuario usuario) {
        try {
            return authService.registerUser(usuario);
        } catch (Exception e) {
            e.printStackTrace(); // 👈 mostra o erro completo no console
            return "Erro interno ao registrar usuário: " + e.getMessage();
        }
    }
}
