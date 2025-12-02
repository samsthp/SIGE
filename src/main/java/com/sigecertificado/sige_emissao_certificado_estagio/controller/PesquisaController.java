package com.sigecertificado.sige_emissao_certificado_estagio.controller;

import com.sigecertificado.sige_emissao_certificado_estagio.dto.PesquisaFiltroDTO;
import com.sigecertificado.sige_emissao_certificado_estagio.model.Pesquisa;
import com.sigecertificado.sige_emissao_certificado_estagio.service.PesquisaService;
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
