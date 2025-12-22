package com.sige.controller;

import com.sige.dto.HistoricoDTO;
import com.sige.model.Estagio;
import com.sige.service.EstagioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/estagios") // ✅ corrigido para bater com o fetch do HTML
public class EstagioController {

    @Autowired
    private EstagioService estagioService;

    // Listar histórico de estágios de um aluno
    @GetMapping("/historico/{alunoId}")
    public List<HistoricoDTO> listarHistorico(@PathVariable Long alunoId) {
        List<Estagio> estagios = estagioService.listarHistorico(alunoId);

        // Converte cada Estagio em HistoricoDTO
        return estagios.stream()
                .map(HistoricoDTO::new)
                .collect(Collectors.toList());
    }

    // Acompanhar estágio específico
    @GetMapping("/{estagioId}")
    public Estagio acompanharEstagio(@PathVariable Long estagioId) {
        return estagioService.acompanharEstagio(estagioId);
    }
}