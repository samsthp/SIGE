package com.sige.controller;

import com.sige.model.ListaVagas;
import com.sige.service.ListaVagasService;
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
