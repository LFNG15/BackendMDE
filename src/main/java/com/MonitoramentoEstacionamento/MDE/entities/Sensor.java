package com.MonitoramentoEstacionamento.MDE.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Sensor {

    // Getters e Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sensorId;

    @OneToOne
    @JoinColumn(name = "vaga_id", nullable = false)
    private Vaga vaga;

    @Column(length = 50)
    private String status = "Ativo";

}
