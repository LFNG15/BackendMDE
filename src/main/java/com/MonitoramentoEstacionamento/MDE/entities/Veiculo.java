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
    private String placa;

    @Column(length = 50)
    private String modelo;

    @Column(length = 20)
    private String cor;

    @Column(length = 20)
    private String tipoVeiculo;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "clienteId", nullable = false)
    private Cliente cliente;

}