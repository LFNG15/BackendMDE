package com.MonitoramentoEstacionamento.MDE.entities;
import jakarta.persistence.*;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sensorId;

    @OneToOne
    @JoinColumn(name = "vaga_id", nullable = false)
    private Vaga vaga;

    @Column(length = 50)
    private String status = "Ativo";

    // Getters e Setters
}
