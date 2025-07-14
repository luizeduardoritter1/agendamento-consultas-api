package com.app.agendamentoConsultaApi.service;

import com.app.agendamentoConsultaApi.dto.ProfessionalRequestDTO;
import com.app.agendamentoConsultaApi.dto.ProfessionalResponseDTO;
import com.app.agendamentoConsultaApi.model.Professional;
import com.app.agendamentoConsultaApi.repository.ProfessionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService {

    private final ProfessionalRepository professionalRepository;

    public ProfessionalService(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    public Professional criar(ProfessionalRequestDTO dto){
        Professional professional = Professional.builder()
                .name(dto.nome())
                .especialidade(dto.especialidade())
                .build();

        return professionalRepository.save(professional);
    }

    public List<ProfessionalResponseDTO> listarTodos(){
        return professionalRepository.findAll().stream()
                .map(p -> new  ProfessionalResponseDTO(
                        p.getId(),
                        p.getName(),
                        p.getEspecialidade()
                ))
                .toList();
    }
}
