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
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroTelefone;
    private String mensagem;
    private StatusMensagemEnum statusMensagemEnum;
    private LocalDateTime enviadoEm;
}
