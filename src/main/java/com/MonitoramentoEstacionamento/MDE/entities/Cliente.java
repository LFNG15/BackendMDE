package com.MonitoramentoEstacionamento.MDE.entities;
import jakarta.persistence.*;

//a gente vai usar mesmo essa porra?

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clienteId;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 14, unique = true)
    private String cpf;

    @Column(length = 15)
    private String telefone;

    @Column(length = 50)
    private String email;

    // Getters e Setters
}