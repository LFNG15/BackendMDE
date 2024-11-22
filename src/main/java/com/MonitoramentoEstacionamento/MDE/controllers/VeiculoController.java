package com.MonitoramentoEstacionamento.MDE.controllers;

import com.MonitoramentoEstacionamento.MDE.entities.Veiculo;
import com.MonitoramentoEstacionamento.MDE.services.VeiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping("/associar/{clienteId}")
    public ResponseEntity<Veiculo> associarVeiculo(@PathVariable Integer clienteId, @RequestBody @Valid Veiculo veiculo) {
        Veiculo veiculoCadastrado = veiculoService.associarVeiculoAoCliente(clienteId, veiculo);
        return ResponseEntity.ok(veiculoCadastrado);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Veiculo>> buscarVeiculos(@PathVariable Integer clienteId) {
        List<Veiculo> veiculos = veiculoService.buscarVeiculosDoCliente(clienteId);
        return ResponseEntity.ok(veiculos);
    }

    @PutMapping("/atualizar/{clienteId}/{veiculoId}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Integer clienteId,
                                                    @PathVariable Integer veiculoId,
                                                    @RequestBody @Valid Veiculo veiculo) {
        Veiculo veiculoAtualizado = veiculoService.atualizarVeiculo(clienteId, veiculoId, veiculo);
        return ResponseEntity.ok(veiculoAtualizado);
    }
}
