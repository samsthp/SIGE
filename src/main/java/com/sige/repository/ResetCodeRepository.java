package com.sige.repository;

import com.sige.model.ResetCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResetCodeRepository extends JpaRepository<ResetCode, Long> {

    Optional<ResetCode> findByEmailAndCodigoAndUsadoFalse(String email, String codigo);

    List<ResetCode> findAllByEmailAndUsadoFalse(String email);

}
