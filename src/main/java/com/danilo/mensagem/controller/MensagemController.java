package com.danilo.mensagem.controller;

import com.danilo.mensagem.business.MensagemService;
import com.danilo.mensagem.business.dto.out.MensagemDTOResponse;
import com.danilo.mensagem.business.enums.StatusMensagemEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mensagem")
@Tag(name = "Mensagem", description = "Alteração e Busca de mensagens")
public class MensagemController {

    private final MensagemService mensagemService;

    @PatchMapping("/{id}/status")
    @Operation(summary = "Atualizar Status", description = "Atualiza status da mensagem")
    @ApiResponse(responseCode = "200", description = "Status atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Parâmetro inválido")
    @ApiResponse(responseCode = "404", description = "Mensagem não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<MensagemDTOResponse> atualizarStatus(@PathVariable Long id,
                                                               @RequestParam StatusMensagemEnum status){
        return ResponseEntity.ok(mensagemService.atualizarStatus(id, status));
    }

    @GetMapping("/relatorio")
    @Operation(summary = "Busca Mensagem", description = "Busca mensagem por status")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Parâmetro inválido")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<MensagemDTOResponse>> buscarMensagemPorStatus(@RequestParam StatusMensagemEnum status){
        return ResponseEntity.ok(mensagemService.buscaMensagemPorStatus(status));
    }
}
