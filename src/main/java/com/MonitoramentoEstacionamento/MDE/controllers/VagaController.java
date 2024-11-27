package com.MonitoramentoEstacionamento.MDE.controllers;

import com.MonitoramentoEstacionamento.MDE.entities.Vaga;
import com.MonitoramentoEstacionamento.MDE.services.VagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
@RequiredArgsConstructor
public class VagaController {

    private final VagaService vagaService;

    @GetMapping
    public ResponseEntity<List<Vaga>> listarVagas() {
        return ResponseEntity.ok(vagaService.listarVagas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(vagaService.buscarPorId(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Vaga>> listarPorStatus(@PathVariable String status) {
        return ResponseEntity.ok(vagaService.listarPorStatus(status));
    }

    @PostMapping
    public ResponseEntity<Vaga> criarVaga(@RequestBody Vaga vaga) {
        return ResponseEntity.ok(vagaService.salvar(vaga));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaga> atualizarVaga(@PathVariable Integer id, @RequestBody Vaga vaga) {
        return ResponseEntity.ok(vagaService.atualizar(id, vaga));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVaga(@PathVariable Integer id) {
        vagaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
