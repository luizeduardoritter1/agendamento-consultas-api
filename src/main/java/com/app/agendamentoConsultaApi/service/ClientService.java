package com.app.agendamentoConsultaApi.service;

import com.app.agendamentoConsultaApi.dto.ClientRequestDTO;
import com.app.agendamentoConsultaApi.dto.ClientResponseDTO;
import com.app.agendamentoConsultaApi.model.Client;
import com.app.agendamentoConsultaApi.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client criar(ClientRequestDTO dto){
        return clientRepository.save(Client.builder()
                .name(dto.name())
                .cpf(dto.cpf())
                .email(dto.email())
                .telefone(dto.telefone())
                .build());
    }

    public List<ClientResponseDTO> listarTodos(){
        return clientRepository.findAll().stream()
                .map(c -> new ClientResponseDTO(c.getId(), c.getName(), c.getEmail() ,c.getTelefone()))
                .toList();
    }

    public Client buscarPorId(Long id){
        return clientRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
    }
}
