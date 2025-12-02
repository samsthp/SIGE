package com.sige.controller;

import com.sige.model.Empresa;
import com.sige.repository.EmpresaRepository;
import com.sige.service.EmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "*")
public class EmpresaController {

    private final EmpresaRepository empresaRepository;
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaRepository empresaRepository,
                             EmpresaService empresaService) {
        this.empresaRepository = empresaRepository;
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }

    @PostMapping
    public Empresa criar(@RequestBody Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @PutMapping("/{id}")
    public Empresa atualizar(@PathVariable Long id, @RequestBody Empresa empresa) {
        return empresaService.atualizar(id, empresa);
    }
}
