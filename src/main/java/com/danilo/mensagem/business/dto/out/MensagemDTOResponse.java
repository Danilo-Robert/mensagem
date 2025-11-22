package com.danilo.mensagem.business.dto.out;

import com.danilo.mensagem.business.enums.StatusMensagemEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MensagemDTOResponse {

    private Long id;
    private String numeroTelefone;
    private String mensagem;
    private StatusMensagemEnum statusMensagemEnum;
    private LocalDateTime enviadoEm;
}
