package com.app.agendamentoConsultaApi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //@ID define a pk do banco e @GeneratedValue(strategy = GenerationType.IDENTITY) Define a estratégia de geração automática do ID. No caso do IDENTITY, o valor será gerado pelo próprio banco de dados, geralmente usando auto-incremento.
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String telefone;

}