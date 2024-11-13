package com.MonitoramentoEstacionamento.MDE.controllers;

import com.MonitoramentoEstacionamento.MDE.entities.Estacionamento;
import com.MonitoramentoEstacionamento.MDE.services.EstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @GetMapping
    public List<Estacionamento> listarEstacionamentos() {
        return estacionamentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estacionamento> buscarEstacionamento(@PathVariable Integer id) {
        return ResponseEntity.of(estacionamentoService.findById(id));
    }

    @PostMapping
    public Estacionamento criarEstacionamento(@RequestBody Estacionamento estacionamento) {
        return estacionamentoService.save(estacionamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estacionamento> atualizarEstacionamento(@PathVariable Integer id, @RequestBody Estacionamento estacionamento) {
        return ResponseEntity.of(estacionamentoService.update(id, estacionamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstacionamento(@PathVariable Integer id) {
        estacionamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
