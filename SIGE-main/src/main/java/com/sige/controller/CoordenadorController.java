package com.sige.controller;

import com.sige.model.Usuario;
import com.sige.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coordenador")
@CrossOrigin(origins = "*")
public class CoordenadorController {

    private final UsuarioService usuarioService;

    public CoordenadorController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PutMapping("/{id}")
    public Usuario atualizarPerfil(@PathVariable Long id, @RequestBody Usuario dados) {
        return usuarioService.atualizarPerfil(id, dados);
    }

    @GetMapping("/api/coordenador/teste")
    public String rotaCoordenador() {
        return "Acesso permitido: COORDENADOR";
    }

}
