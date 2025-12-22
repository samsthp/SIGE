package com.sige.dto;

import lombok.Data;

@Data
public class AvaliacaoDTO {
    private int nota;
    private String descricao;
    private Long alunoId;
    private Long empresaId;
}
