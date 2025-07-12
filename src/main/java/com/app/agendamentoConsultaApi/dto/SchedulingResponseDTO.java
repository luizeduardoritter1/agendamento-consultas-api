package com.app.agendamentoConsultaApi.dto;

import java.time.LocalDateTime;

public record SchedulingResponseDTO(
        Long id,
        String nomeCliente,
        String nomeProfissional,
        LocalDateTime dataHora,
        String observacao
) {}
