package com.sige.repository;

import com.sige.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByMatricula(String matricula);

    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByCnpj(String cnpj);

    Optional<Usuario> findByEmail(String email);

    // 🔥 BUSCA GENÉRICA PELO LOGIN (JWT / AUTH)
    default Optional<Usuario> findByPrincipal(String principal) {
        return findByEmail(principal)
                .or(() -> findByCpf(principal))
                .or(() -> findByCnpj(principal))
                .or(() -> findByMatricula(principal));
    }

    // 🔐 ATUALIZA SENHA
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("""
        UPDATE Usuario u
        SET u.senha = :senha
        WHERE u.email = :email
    """)
    int atualizarSenha(
            @Param("email") String email,
            @Param("senha") String senha
    );
}
