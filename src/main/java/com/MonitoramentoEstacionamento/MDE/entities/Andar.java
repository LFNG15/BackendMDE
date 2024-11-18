package com.MonitoramentoEstacionamento.MDE.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@Entity
public class Andar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer andarId;

    @Column(nullable = false, length = 50)
    private String descricao;

    @OneToMany(mappedBy = "andar")
    private List<Vaga> vagas;
}