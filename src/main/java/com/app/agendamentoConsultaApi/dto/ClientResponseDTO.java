package com.app.agendamentoConsultaApi.dto;

public record ClientResponseDTO(
        Long id,
        String name,
        String email,
        String telefone
) {}
