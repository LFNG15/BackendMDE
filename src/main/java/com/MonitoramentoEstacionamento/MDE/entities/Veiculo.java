package com.MonitoramentoEstacionamento.MDE.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Veiculo {

    // Getters e Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer veiculoId;

    @Column(nullable = false, length = 10)
    private String placa; //precisa de placa?
    //se sim, deve haver o mesmo cuidado que se tem com os dados sensiveis do usuario?

    @Column(length = 50)
    private String modelo;

    @Column(length = 20)
    private String cor;

    @Column(length = 20)
    private String tipoVeiculo;

}