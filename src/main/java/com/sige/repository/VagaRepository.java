package com.sige.repository;

import com.sige.model.Vaga;
import com.sige.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

    List<Vaga> findByCursoRelacionadoContainingIgnoreCase(String curso);
    List<Vaga> findByEstadoContainingIgnoreCase(String estado);

    // 🔥 NOVO – vagas da empresa
    List<Vaga> findByEmpresa(Usuario empresa);
}
