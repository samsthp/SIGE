package com.sigecertificado.sige_emissao_certificado_estagio.controller;

import com.sigecertificado.sige_emissao_certificado_estagio.model.ListaVagas;
import com.sigecertificado.sige_emissao_certificado_estagio.service.ListaVagasService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/listadevagas")
public class ListaVagasController {
    private final ListaVagasService servico;
    public ListaVagasController(ListaVagasService service) {
        servico = service;
    }
    @GetMapping
    public List<ListaVagas> listarTodasVagas() {
        return servico.listarVagas();
    }
}
