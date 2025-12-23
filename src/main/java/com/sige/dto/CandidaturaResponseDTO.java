package com.sige.dto;

import com.sige.model.Candidatura;

public class CandidaturaResponseDTO {

    private Long id;
    private String status;

    private Long vagaId;
    private String vagaTitulo;

    private Long alunoId;
    private String alunoNome;
    private String alunoEmail;

    public CandidaturaResponseDTO(Candidatura c) {
        this.id = c.getId();
        this.status = c.getStatus().name(); // 🔥 AQUI ESTÁ A CORREÇÃO

        this.vagaId = c.getVaga().getId();
        this.vagaTitulo = c.getVaga().getTitulo();

        this.alunoId = c.getAluno().getId();
        this.alunoNome = c.getAluno().getNome();
        this.alunoEmail = c.getAluno().getEmail();
    }

    public Long getId() { return id; }
    public String getStatus() { return status; }

    public Long getVagaId() { return vagaId; }
    public String getVagaTitulo() { return vagaTitulo; }

    public Long getAlunoId() { return alunoId; }
    public String getAlunoNome() { return alunoNome; }
    public String getAlunoEmail() { return alunoEmail; }
}
