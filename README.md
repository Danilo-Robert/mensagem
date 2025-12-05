API para Mensagens SMS

Objetivo: Implemente uma aplicação para gerenciar o status de mensagens SMS e criar
relatórios.


Especificações Técnicas:

1. API REST:
   
○ Atualizar Status: 
Crie uma rota para atualizar o status de envio de
mensagens SMS no banco de dados.

○ Relatórios: 
Implemente uma rota que retorne as mensagens com um status específico das últimas 24 horas.

2. Regras de Negócio:
 
○ IDs devem ser puramente numéricos.

○ Status válidos: "ENVIADO", "RECEBIDO", "ERRO DE ENVIO".

○ Retorne erros adequados caso o ID não exista no banco.


3. Banco de Dados:
   
Modelo de exemplo:

public class SmsMessage {

private Long id;

private String phoneNumber;

private String status; // ENVIADO, RECEBIDO, ERRO DE ENVIO

private LocalDateTime sentAt;

}

4. Validações:

○ Requisições inválidas devem ser rejeitadas.

○ Atualizações de status devem ser precisas e consistentes.
