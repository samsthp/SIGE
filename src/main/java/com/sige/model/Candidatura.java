package com.sige.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER) // carregar aluno para serialização simples
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oferta_id")
    @JsonIgnoreProperties({"empresa"}) // evitar serializar toda empresa em candidato
    private OfertaEstagio oferta;

    @Enumerated(EnumType.STRING)
    private StatusCandidatura status = StatusCandidatura.INSCRITO;
}
