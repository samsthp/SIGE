package com.sige.repository;

import com.sige.model.Vaga;
import com.sige.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======
import java.util.List;
>>>>>>> origin/main

import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
<<<<<<< HEAD
    List<Vaga> findByCursoRelacionadoContainingIgnoreCase(String curso);
    List<Vaga> findByEstadoContainingIgnoreCase(String estado);
    List<Vaga> findByEmpresaContainingIgnoreCase(String empresa);
}
=======

    List<Vaga> findByCursoRelacionadoContainingIgnoreCase(String curso);
    List<Vaga> findByEstadoContainingIgnoreCase(String estado);

    // 🔥 NOVO – vagas da empresa
    List<Vaga> findByEmpresa(Usuario empresa);
}
>>>>>>> origin/main
