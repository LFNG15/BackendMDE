package com.MonitoramentoEstacionamento.MDE.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estacionamentoId;

    @Column(nullable = false)
    private String nomeEstacionamento;

    private String endereco;

    private Integer capacidadeTotal;

    @OneToMany(mappedBy = "estacionamento")
    private List<Vaga> vagas;

    // Getters e Setters
}
