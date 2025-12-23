package com.sige.service;

import com.sige.model.Candidatura;
import com.sige.model.OfertaEstagio;
import com.sige.repository.CandidaturaRepository;
import com.sige.repository.OfertaEstagioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class OfertaService {

        private final OfertaEstagioRepository ofertaRepository;

        public OfertaService(OfertaEstagioRepository ofertaRepository) {
            this.ofertaRepository = ofertaRepository;
        }

        public OfertaEstagio criar(OfertaEstagio oferta) {
            return ofertaRepository.save(oferta);
        }

        public List<OfertaEstagio> listarPorEmpresa(Long empresaId) {
            return ofertaRepository.findByEmpresaId(empresaId);
        }

        public List<OfertaEstagio> listarTodas() {
            return ofertaRepository.findAll();
        }
    }

