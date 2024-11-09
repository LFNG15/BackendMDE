package com.MonitoramentoEstacionamento.MDE.entities;
import jakarta.persistence.*;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sensorId;

    @OneToOne
    @JoinColumn(name = "vaga_id", nullable = false)
    private Vaga vaga;

    @Column(length = 50)
    private String status = "Ativo";

    // Getters e Setters
    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
