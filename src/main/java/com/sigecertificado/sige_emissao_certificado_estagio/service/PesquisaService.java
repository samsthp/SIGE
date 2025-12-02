package com.sigecertificado.sige_emissao_certificado_estagio.service;


import com.sigecertificado.sige_emissao_certificado_estagio.dto.PesquisaFiltroDTO;
import com.sigecertificado.sige_emissao_certificado_estagio.model.Pesquisa;
import com.sigecertificado.sige_emissao_certificado_estagio.repository.PesquisaRepository;
import com.sigecertificado.sige_emissao_certificado_estagio.specifications.PesquisaSpecifications;
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
