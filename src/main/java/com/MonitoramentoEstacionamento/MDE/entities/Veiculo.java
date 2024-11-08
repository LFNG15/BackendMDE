package com.MonitoramentoEstacionamento.MDE.entities;
import jakarta.persistence.*;

//ta faltando tipo de veiculo hein, coisa boa

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer veiculoId;

    @Column(nullable = false, length = 10)
    private String placa;

    @Column(length = 50)
    private String modelo;

    @Column(length = 20)
    private String cor;

    // Getters e Setters
}