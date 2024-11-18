package com.MonitoramentoEstacionamento.MDE.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vagaId;

    @Column(nullable = false, length = 10)
    private String numeroVaga;

    @Column(nullable = false, length = 50)
    private String tipoVaga;

    @Column(length = 50)
    private String status = "Disponível";

    @OneToOne(mappedBy = "vaga")
    private Sensor sensor;

    @ManyToOne
    @JoinColumn(name = "andar_id", nullable = false)
    private Andar andar;
}