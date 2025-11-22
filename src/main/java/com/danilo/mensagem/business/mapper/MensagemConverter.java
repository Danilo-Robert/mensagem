package com.danilo.mensagem.business.mapper;

import com.danilo.mensagem.business.dto.in.MensagemDTORequest;
import com.danilo.mensagem.business.dto.out.MensagemDTOResponse;
import com.danilo.mensagem.infrastructure.entity.MensagemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface MensagemConverter {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enviadoEm", ignore = true)
    @Mapping(target = "statusMensagemEnum", ignore = true)
    MensagemEntity paraMensagemEntity(MensagemDTORequest mensagemDTORequest);

    MensagemDTOResponse paraMensagemDTO(MensagemEntity mensagem);
}
