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
    public Integer getEstacionamentoId() {
        return estacionamentoId;
    }

    public void setEstacionamentoId(Integer estacionamentoId) {
        this.estacionamentoId = estacionamentoId;
    }

    public String getNomeEstacionamento() {
        return nomeEstacionamento;
    }

    public void setNomeEstacionamento(String nomeEstacionamento) {
        this.nomeEstacionamento = nomeEstacionamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(Integer capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }
}
