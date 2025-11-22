package com.danilo.mensagem.business;

import com.danilo.mensagem.business.dto.in.MensagemDTORequest;
import com.danilo.mensagem.business.dto.out.MensagemDTOResponse;
import com.danilo.mensagem.business.enums.StatusMensagemEnum;
import com.danilo.mensagem.business.mapper.MensagemConverter;
import com.danilo.mensagem.infrastructure.entity.MensagemEntity;
import com.danilo.mensagem.infrastructure.exceptions.ResourceNotFoundException;
import com.danilo.mensagem.infrastructure.repository.MensagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MensagemService {

    private final MensagemConverter mensagemConverter;
    private final MensagemRepository mensagemRepository;

    public MensagemDTOResponse atualizarStatus(Long id, StatusMensagemEnum statusEnum){

        MensagemEntity entity = mensagemRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Mensagem não encontrada" + id)
        );

        entity.setStatusMensagemEnum(statusEnum);
        return mensagemConverter.paraMensagemDTO(mensagemRepository.save(entity));
    }

    public List<MensagemDTOResponse> buscaMensagemPorStatus(StatusMensagemEnum statusEnum){
        LocalDateTime limiteTempo = LocalDateTime.now().minusHours(24);

        List<MensagemEntity> mensagens = mensagemRepository.findAll().stream().filter(
                m -> m.getStatusMensagemEnum() == statusEnum && m.getEnviadoEm().isAfter(limiteTempo)).toList();

        return mensagens.stream().map(mensagemConverter::paraMensagemDTO).toList();
    }
}
