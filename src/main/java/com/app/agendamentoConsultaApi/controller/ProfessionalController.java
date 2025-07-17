package com.app.agendamentoConsultaApi.controller;

import com.app.agendamentoConsultaApi.dto.ProfessionalRequestDTO;
import com.app.agendamentoConsultaApi.dto.ProfessionalResponseDTO;
import com.app.agendamentoConsultaApi.model.Professional;
import com.app.agendamentoConsultaApi.service.ProfessionalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfessionalController {

    private final ProfessionalService professionalService;

    public ProfessionalController(ProfessionalService professionalSevice) {
        this.professionalService = professionalSevice;
    }

    @PostMapping
    public ResponseEntity<ProfessionalResponseDTO> criar(@RequestBody @Valid ProfessionalRequestDTO dto){
        Professional professional = professionalService.criar(dto);
        return ResponseEntity.ok(new ProfessionalResponseDTO(
                professional.getId(),
                professional.getName(),
                professional.getEspecialidade()
        ));
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalResponseDTO>> listarTodos(){
        return ResponseEntity.ok(professionalService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalResponseDTO> buscarPorId(@PathVariable Long id){
        Professional professional = professionalService.buscarPorId(id);
        return ResponseEntity.ok(new ProfessionalResponseDTO(
                professional.getId(),
                professional.getName(),
                professional.getEspecialidade()
        ));
    }
}