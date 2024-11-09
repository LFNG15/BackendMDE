package com.MonitoramentoEstacionamento.MDE.services;

import com.MonitoramentoEstacionamento.MDE.entities.Sensor;
import com.MonitoramentoEstacionamento.MDE.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public Sensor salvarSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public List<Sensor> listarTodos() {
        return sensorRepository.findAll();
    }

    public Optional<Sensor> buscarPorId(Integer id) {
        return sensorRepository.findById(id);
    }

    public Sensor atualizarSensor(Integer id, Sensor sensorAtualizado) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor não encontrado"));

        sensor.setStatus(sensorAtualizado.getStatus());

        return sensorRepository.save(sensor);
    }

    public void deletarSensor(Integer id) {
        sensorRepository.deleteById(id);
    }
}