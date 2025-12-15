package com.sigecertificado.sige_emissao_certificado_estagio.service;

import com.sigecertificado.sige_emissao_certificado_estagio.model.ListaVagas;
import com.sigecertificado.sige_emissao_certificado_estagio.repository.ListaVagasRepository;
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
