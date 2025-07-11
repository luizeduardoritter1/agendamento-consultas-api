package com.app.agendamentoConsultaApi.repository;

import com.app.agendamentoConsultaApi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
