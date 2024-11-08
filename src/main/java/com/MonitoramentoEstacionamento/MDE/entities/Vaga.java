package com.MonitoramentoEstacionamento.MDE.entities;
import jakarta.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "estacionamento_id", nullable = false)
    private Estacionamento estacionamento;

    @OneToOne(mappedBy = "vaga")
    private Sensor sensor;

    // Getters e Setters
}
