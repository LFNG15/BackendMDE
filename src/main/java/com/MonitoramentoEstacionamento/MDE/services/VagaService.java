package com.MonitoramentoEstacionamento.MDE.services;

import com.MonitoramentoEstacionamento.MDE.entities.Vaga;
import com.MonitoramentoEstacionamento.MDE.entities.Veiculo;
import com.MonitoramentoEstacionamento.MDE.repositories.VagaRepository;
import com.MonitoramentoEstacionamento.MDE.repositories.VeiculoRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public String ocuparVagaComVeiculo(Integer vagaId, Integer veiculoId) {
        Vaga vaga = vagaRepository.findById(vagaId)
                .orElseThrow(() -> new ResourceNotFoundException("Vaga não encontrada"));

        Veiculo veiculo = veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new ResourceNotFoundException("Veículo não encontrado"));

        if (!vaga.getTipoVaga().equalsIgnoreCase(veiculo.getTipoVeiculo())) {
            throw new IllegalArgumentException("Tipo de veículo não corresponde ao tipo da vaga.");
        }

        vaga.setStatus("Ocupado");
        vagaRepository.save(vaga);

        return "Vaga ocupada com sucesso!";
    }
}