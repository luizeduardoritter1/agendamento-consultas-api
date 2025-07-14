package com.app.agendamentoConsultaApi.dto;

public record ClientRequestDTO(
        String name,
        String cpf,
        String email,
        String telefone
) {}
