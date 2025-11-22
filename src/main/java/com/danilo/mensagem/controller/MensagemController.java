package com.danilo.mensagem.controller;

import com.danilo.mensagem.business.MensagemService;
import com.danilo.mensagem.business.dto.out.MensagemDTOResponse;
import com.danilo.mensagem.business.enums.StatusMensagemEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mensagem")

public class MensagemController {

    private final MensagemService mensagemService;

    @PatchMapping
    public ResponseEntity<MensagemDTOResponse> atualizarStatus(@PathVariable Long id,
                                                               @RequestParam StatusMensagemEnum status){
        return ResponseEntity.ok(mensagemService.atualizarStatus(id, status));
    }

    @GetMapping
    public ResponseEntity<List<MensagemDTOResponse>> buscarMensagemPorStatus(@RequestParam StatusMensagemEnum status){
        return ResponseEntity.ok(mensagemService.buscaMensagemPorStatus(status));
    }
}
