package com.sige.repository;

import com.sige.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByCnpj(String cnpj);

    Optional<Usuario> findByMatricula(String matricula);
}
