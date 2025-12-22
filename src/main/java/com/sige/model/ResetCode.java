package com.sige.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reset_code")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResetCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private LocalDateTime expiration;

    @Column(nullable = false)
    private boolean usado = false;

}
