package com.sige.repository;

import com.sige.model.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Long>, JpaSpecificationExecutor {
}
