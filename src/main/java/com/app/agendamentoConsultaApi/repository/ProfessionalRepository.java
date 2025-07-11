package com.app.agendamentoConsultaApi.repository;

import com.app.agendamentoConsultaApi.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
}
