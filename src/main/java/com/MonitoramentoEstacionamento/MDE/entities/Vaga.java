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
    public Integer getVagaId() {
        return vagaId;
    }

    public void setVagaId(Integer vagaId) {
        this.vagaId = vagaId;
    }

    public String getNumeroVaga() {
        return numeroVaga;
    }

    public void setNumeroVaga(String numeroVaga) {
        this.numeroVaga = numeroVaga;
    }

    public String getTipoVaga() {
        return tipoVaga;
    }

    public void setTipoVaga(String tipoVaga) {
        this.tipoVaga = tipoVaga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
