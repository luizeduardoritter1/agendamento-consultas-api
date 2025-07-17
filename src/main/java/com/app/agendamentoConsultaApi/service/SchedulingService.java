package com.app.agendamentoConsultaApi.service;

import com.app.agendamentoConsultaApi.dto.SchedulingRequestDTO;
import com.app.agendamentoConsultaApi.dto.SchedulingResponseDTO;
import com.app.agendamentoConsultaApi.exception.HorarioIndisponivelException;
import com.app.agendamentoConsultaApi.model.Client;
import com.app.agendamentoConsultaApi.model.Professional;
import com.app.agendamentoConsultaApi.model.Scheduling;
import com.app.agendamentoConsultaApi.repository.ClientRepository;
import com.app.agendamentoConsultaApi.repository.ProfessionalRepository;
import com.app.agendamentoConsultaApi.repository.SchedulingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {

    private final SchedulingRepository schedulingRepository;
    private final ClientRepository clientRepository;
    private final ProfessionalRepository professionalRepository;

    public SchedulingService(SchedulingRepository schedulingRepository, ClientRepository clientRepository, ProfessionalRepository professionalRepository) {
        this.schedulingRepository = schedulingRepository;
        this.clientRepository = clientRepository;
        this.professionalRepository = professionalRepository;
    }

    public SchedulingResponseDTO agendar(SchedulingRequestDTO dto){
        Client cliente = clientRepository.findById(dto.clienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        Professional profissional = professionalRepository.findById(dto.profissionalId())
                .orElseThrow(() -> new IllegalArgumentException("Profissional não encontrado."));

        boolean ocupado = schedulingRepository.existsByProfissionalAndDataHora(profissional, dto.dataHora());
        if(ocupado){
            throw new HorarioIndisponivelException("Horário já ocupado para este profissional.");
        }

        Scheduling agendamento = Scheduling.builder()

                .cliente(cliente)
                .profissional(profissional)
                .dataHora(dto.dataHora())
                .observacao(dto.observacao())
                .build();

        Scheduling salvo = schedulingRepository.save(agendamento);

        return new SchedulingResponseDTO(
                salvo.getId(),
                cliente.getName(),
                profissional.getName(),
                salvo.getDataHora(),
                salvo.getObservacao()
        );
    }

    public SchedulingResponseDTO buscarPorId(Long id){
        Scheduling agendamento = schedulingRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Agendamento não encontrado"));

        return new SchedulingResponseDTO(
                agendamento.getId(),
                agendamento.getCliente().getName(),
                agendamento.getProfissional().getName(),
                agendamento.getDataHora(),
                agendamento.getObservacao()
        );
    }
}
