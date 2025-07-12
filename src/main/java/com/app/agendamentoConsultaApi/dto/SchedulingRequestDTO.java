package com.app.agendamentoConsultaApi.dto;

import java.time.LocalDateTime;

public record SchedulingRequestDTO(
        Long clienteId,
        Long profissionalId,
        LocalDateTime dataHora,
        String observacao
        ) {}
