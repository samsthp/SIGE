package com.sige.controller;

import com.sige.dto.PesquisaFiltroDTO;
import com.sige.model.Pesquisa;
import com.sige.service.PesquisaService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pesquisacomfiltros")
public class PesquisaController {
    private final PesquisaService service;
    
    public PesquisaController(PesquisaService servico) {
        service = servico;
    }
    
    @PostMapping
    public List<Pesquisa> filtrar(@RequestBody PesquisaFiltroDTO dto) {
        return service.combinarFiltros(dto);
    }
}
