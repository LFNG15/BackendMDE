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

    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public Optional<Sensor> findById(Integer id) {
        return sensorRepository.findById(id);
    }

    public Optional<Sensor> update(Integer id, Sensor sensorAtualizado) {
        return sensorRepository.findById(id)
                .map(sensor -> {
                    sensor.setStatus(sensorAtualizado.getStatus());
                    return sensorRepository.save(sensor);
                });
    }

    public void deleteById(Integer id) {
        sensorRepository.deleteById(id);
    }
}
