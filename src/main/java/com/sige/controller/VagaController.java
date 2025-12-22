package com.sige.controller;

import com.sige.model.Vaga;
<<<<<<< HEAD
import com.sige.service.VagaService;

import org.springframework.beans.factory.annotation.Autowired;
=======
import com.sige.service.VagaService;
import com.sige.repository.VagaRepository;
>>>>>>> 6e516700151d0d8c92cf620a360faec33aa9aa0d
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/api/vagas")
@CrossOrigin(origins = "*")
=======
public class VagaController {

<<<<<<< HEAD
    @Autowired
    private VagaService vagaService;

    @GetMapping
    public List<Vaga> listarTodas() {
        return vagaService.listarTodas();
=
    }

<<<<<<< HEAD
    @GetMapping("/curso")
    public List<Vaga> buscarPorCurso(@RequestParam String curso) {
        return vagaService.buscarPorCurso(curso);
=======
    @GetMapping
    public List<Vaga> listarTodas() {
        return vagaService.listarTodas();
    }

    @GetMapping("/curso/{curso}")
    public List<Vaga> buscarPorCurso(@PathVariable String curso) {
        return vagaService.buscarPorCurso(curso);
    }

    @GetMapping("/estado/{estado}")
    public List<Vaga> buscarPorEstado(@PathVariable String estado) {
        return vagaService.buscarPorEstado(estado);
    }

    @GetMapping("/empresa/{empresa}")
    public List<Vaga> buscarPorEmpresa(@PathVariable String empresa) {
        return vagaService.buscarPorEmpresa(empresa);
    }
  
   @PostMapping("/publicar")
    public String publicarVaga(@RequestBody Vaga vaga) {
        vagaRepository.save(vaga);
        return "Vaga publicada com sucesso!";
>>>>>>> 6e516700151d0d8c92cf620a360faec33aa9aa0d
    }

<<<<<<< HEAD
    @GetMapping("/estado")
    public List<Vaga> buscarPorEstado(@RequestParam String estado) {
        return vagaService.buscarPorEstado(estado);
    }

    @PostMapping
    public Vaga cadastrar(@RequestBody Vaga vaga) {
        return vagaService.salvar(vaga);
    }
=======
    @GetMapping("/listar")
    public List<Vaga> listarVagas() {
        return vagaRepository.findAll();
>>>>>>> 6e516700151d0d8c92cf620a360faec33aa9aa0d
}
