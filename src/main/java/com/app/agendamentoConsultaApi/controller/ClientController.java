package com.app.agendamentoConsultaApi.controller;

import com.app.agendamentoConsultaApi.dto.ClientRequestDTO;
import com.app.agendamentoConsultaApi.dto.ClientResponseDTO;
import com.app.agendamentoConsultaApi.model.Client;
import com.app.agendamentoConsultaApi.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> criar(@RequestBody @Valid ClientRequestDTO dto){
        Client client = clientService.criar(dto);
        return ResponseEntity.ok(new ClientResponseDTO(
                client.getId(), client.getName(), client.getEmail(), client.getTelefone()
        ));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> listar(){
        return ResponseEntity.ok(clientService.listarTodos());
    }
}
