package com.sige.repository;

import com.sige.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByMatricula(String matricula);
    List<Usuario> findByCnpj(String cnpj);
    List<Usuario> findByCpf(String cpf);

}
