package com.MonitoramentoEstacionamento.MDE.services;

import com.MonitoramentoEstacionamento.MDE.entities.Sensor;
import com.MonitoramentoEstacionamento.MDE.entities.Vaga;
import com.MonitoramentoEstacionamento.MDE.exceptions.VagaNotFoundException;
import com.MonitoramentoEstacionamento.MDE.exceptions.SensorNotFoundException;
import com.MonitoramentoEstacionamento.MDE.repositories.SensorRepository;
import com.MonitoramentoEstacionamento.MDE.repositories.VagaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final VagaRepository vagaRepository;

    public Sensor cadastrarSensor(Integer vagaId, Sensor sensor) {
        Vaga vaga = vagaRepository.findById(vagaId)
                .orElseThrow(() -> new VagaNotFoundException("Vaga não encontrada"));
        sensor.setVaga(vaga);
        return sensorRepository.save(sensor);
    }

    public Sensor atualizarStatusSensor(Integer sensorId, String novoStatus) {
        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new SensorNotFoundException("Sensor não encontrado"));
        sensor.setStatus(novoStatus);
        return sensorRepository.save(sensor);
    }

    public List<Sensor> listarSensores() {
        return sensorRepository.findAll();
    }

    public void removerSensor(Integer sensorId) {
        if (!sensorRepository.existsById(sensorId)) {
            throw new SensorNotFoundException("Sensor não encontrado");
        }
        sensorRepository.deleteById(sensorId);
    }
}
