package com.MonitoramentoEstacionamento.MDE.controllers;

import com.MonitoramentoEstacionamento.MDE.entities.Sensor;
import com.MonitoramentoEstacionamento.MDE.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensores")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping
    public List<Sensor> listarSensores() {
        return sensorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> buscarSensor(@PathVariable Integer id) {
        return ResponseEntity.of(sensorService.findById(id));
    }

    @PostMapping
    public Sensor criarSensor(@RequestBody Sensor sensor) {
        return sensorService.save(sensor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> atualizarSensor(@PathVariable Integer id, @RequestBody Sensor sensor) {
        return ResponseEntity.of(sensorService.update(id, sensor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSensor(@PathVariable Integer id) {
        sensorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
