package com.sige.service;

import com.sige.dto.CadastroAlunoDTO;

public interface AlunoService {
    void salvar(CadastroAlunoDTO dto);
    boolean existsByCpf(String cpf);
    void enviarEmail(String para, String assunto, String texto);
}
