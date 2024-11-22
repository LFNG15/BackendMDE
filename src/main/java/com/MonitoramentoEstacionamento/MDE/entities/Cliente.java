package com.MonitoramentoEstacionamento.MDE.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Cliente {

    // Getters e Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //talvez utilizar UID???
    private Integer clienteId;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(length = 15)
    private String telefone;

    @Column(length = 50)
    private String email;

    @Column(nullable = false)
    private String password;

}
