package com.app.agendamentoConsultaApi.controller;

import com.app.agendamentoConsultaApi.dto.SchedulingRequestDTO;
import com.app.agendamentoConsultaApi.dto.SchedulingResponseDTO;
import com.app.agendamentoConsultaApi.service.SchedulingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")
public class SchedulingController {

    private final SchedulingService schedulingService;


    public SchedulingController(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @PostMapping
    public ResponseEntity<SchedulingResponseDTO> agendar(@RequestBody @Valid SchedulingRequestDTO dto){
        SchedulingResponseDTO response = schedulingService.agendar(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<SchedulingResponseDTO> buscarPorId(@PathVariable Long id){
        SchedulingResponseDTO response = schedulingService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }
}
