package com.sige.service;


import com.sige.dto.PesquisaFiltroDTO;
import com.sige.model.Pesquisa;
import com.sige.repository.PesquisaRepository;
import com.sige.specifications.PesquisaSpecifications;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PesquisaService {
    private final PesquisaRepository repository;
    public PesquisaService(PesquisaRepository repositorio){
        repository = repositorio;
    }
    public List<Pesquisa> combinarFiltros(PesquisaFiltroDTO dto) {
        Specification<Pesquisa> filtros = Specification.where(PesquisaSpecifications.palavraChave(dto.getPalavraChave())).and(PesquisaSpecifications.area(dto.getArea())).and(PesquisaSpecifications.local(dto.getLocal())).and(PesquisaSpecifications.modalidade(dto.getModalidade()));
        return repository.findAll(filtros);
    }
        
}
