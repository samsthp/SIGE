package com.sige.repository;

import com.sige.model.ListaVagas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaVagasRepository extends JpaRepository<ListaVagas, Long> {
    
}
