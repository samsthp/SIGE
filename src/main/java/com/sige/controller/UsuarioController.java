package com.sige.controller;

import com.sige.model.Usuario;
import com.sige.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping("/cpf/{cpf}")
    public Usuario buscarPorCpf(@PathVariable String cpf) {
        return usuarioService.buscarPorCpf(cpf);
    }

    @PostMapping("/salvar")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }
}
