package com.app.agendamentoConsultaApi.repository;

import com.app.agendamentoConsultaApi.model.Professional;
import com.app.agendamentoConsultaApi.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
    boolean existsByProfissionalAndDataHora(Professional profissional, LocalDateTime dataHora);
}

