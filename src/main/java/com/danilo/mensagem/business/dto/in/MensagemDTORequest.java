package com.danilo.mensagem.business.dto.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MensagemDTORequest {

    private String numeroTelefone;
    private String mensagem;
}
