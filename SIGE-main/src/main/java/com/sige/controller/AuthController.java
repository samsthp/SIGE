package com.sige.controller;

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
    public Map<String, Object> login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public Map<String, Object> registerUser(@RequestBody Usuario usuario) {
        return authService.registerUser(usuario);
    }

    @PostMapping("/forgot")
    public Map<String, Object> forgot(@RequestBody Map<String, String> body) {
        return authService.enviarCodigo(body.get("email"));
    }

    @PostMapping("/validate-code")
    public Map<String, Object> validate(@RequestBody Map<String, String> body) {

        return authService.validarCodigo(body.get("email"), body.get("codigo"));
    }

    @PostMapping("/reset-password")
    public Map<String, Object> reset(@RequestBody Map<String, String> body) {
        return authService.resetarSenha(
                body.get("email"),
                body.get("novaSenha"),
                body.get("codigo")
        );
    }
}
