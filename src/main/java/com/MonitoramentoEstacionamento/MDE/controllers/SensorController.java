package com.MonitoramentoEstacionamento.MDE.controllers;

import com.MonitoramentoEstacionamento.MDE.entities.Sensor;
import com.MonitoramentoEstacionamento.MDE.services.SensorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensores")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @PostMapping("/cadastrar/{vagaId}")
    public ResponseEntity<Sensor> cadastrarSensor(@PathVariable Integer vagaId, @RequestBody @Valid Sensor sensor) {
        Sensor novoSensor = sensorService.cadastrarSensor(vagaId, sensor);
        return ResponseEntity.ok(novoSensor);
    }

    @PutMapping("/atualizar-status/{sensorId}")
    public ResponseEntity<Sensor> atualizarStatusViaHardware(
            @PathVariable Integer sensorId,
            @RequestParam String status) {
        Sensor sensorAtualizado = sensorService.atualizarStatusSensor(sensorId, status);
        return ResponseEntity.ok(sensorAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<Sensor>> listarSensores() {
        List<Sensor> sensores = sensorService.listarSensores();
        return ResponseEntity.ok(sensores);
    }

    @DeleteMapping("/remover/{sensorId}")
    public ResponseEntity<Void> removerSensor(@PathVariable Integer sensorId) {
        sensorService.removerSensor(sensorId);
        return ResponseEntity.noContent().build();
    }
}
