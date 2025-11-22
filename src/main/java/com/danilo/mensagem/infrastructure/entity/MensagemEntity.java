package com.danilo.mensagem.infrastructure.entity;

import com.danilo.mensagem.business.enums.StatusMensagemEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mensagem")
@Builder
public class MensagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroTelefone;
    private String mensagem;
    @Enumerated(EnumType.STRING)
    private StatusMensagemEnum statusMensagemEnum;
    private LocalDateTime enviadoEm;
}
