package com.sige.service;

import com.sige.dto.CadastroEmpresaDTO;

public interface EmpresaService {
    void salvar(CadastroEmpresaDTO dto);
    boolean existsByCnpj(String cnpj);
}
