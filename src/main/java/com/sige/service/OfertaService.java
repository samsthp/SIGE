package com.sige.service;

import com.sige.model.Candidatura;
import com.sige.model.OfertaEstagio;
import com.sige.repository.CandidaturaRepository;
import com.sige.repository.OfertaEstagioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertaService {

    @Autowired
    private OfertaEstagioRepository ofertaRepository;

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    // Criar nova oferta
    public OfertaEstagio criar(OfertaEstagio oferta) {
        return ofertaRepository.save(oferta);
    }

    // 🔹 Listar todas as ofertas de uma empresa específica
    public List<OfertaEstagio> listarPorEmpresa(Long empresaId) {
        return ofertaRepository.findByEmpresaId(empresaId);
    }

    // 🔹 Listar todos os candidatos de uma oferta específica
    public List<Candidatura> listarCandidatosPorOferta(Long ofertaId) {
        return candidaturaRepository.findByOfertaId(ofertaId);
    }

    public List<OfertaEstagio> listarTodas() {
        return ofertaRepository.findAll(); // retorna todas as ofertas
    }
}
