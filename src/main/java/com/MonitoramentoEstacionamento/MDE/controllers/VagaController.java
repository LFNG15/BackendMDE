package com.MonitoramentoEstacionamento.MDE.controllers;

import com.MonitoramentoEstacionamento.MDE.entities.Vaga;
import com.MonitoramentoEstacionamento.MDE.services.VagaService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//analisar o controller e service da vaga
@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @PutMapping("/{vagaId}/ocupar/{veiculoId}")
    public ResponseEntity<String> ocuparVaga(@PathVariable Integer vagaId, @PathVariable Integer veiculoId) {
        try {
            String response = vagaService.ocuparVagaComVeiculo(vagaId, veiculoId);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
