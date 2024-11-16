package com.MonitoramentoEstacionamento.MDE.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Estacionamento {

    // Getters e Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estacionamentoId;

    @Column(nullable = false)
    private String nomeEstacionamento;

    private String endereco;

    private Integer capacidadeTotal;

    @OneToMany(mappedBy = "estacionamento")
    private List<Vaga> vagas;

}
