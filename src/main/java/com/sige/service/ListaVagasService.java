package com.sige.service;

import com.sige.model.ListaVagas;
import com.sige.repository.ListaVagasRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ListaVagasService {
    private final ListaVagasRepository repositorio;
    public ListaVagasService(ListaVagasRepository repository) {
        repositorio = repository;
    }
    public List<ListaVagas> listarVagas() {
        return repositorio.findAll();
    } 
}
