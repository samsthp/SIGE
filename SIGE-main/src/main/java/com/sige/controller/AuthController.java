package com.sige.controller;

import org.springframework.http.ResponseEntity;
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
        return authService.login(request);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario) {
        String resposta = authService.registerUser(usuario);
        return ResponseEntity.ok(resposta);
    }

}
