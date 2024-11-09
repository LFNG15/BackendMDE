package com.MonitoramentoEstacionamento.MDE.services;

import com.MonitoramentoEstacionamento.MDE.entities.Veiculo;
import com.MonitoramentoEstacionamento.MDE.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo salvarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarPorId(Integer id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo atualizarVeiculo(Integer id, Veiculo veiculoAtualizado) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        veiculo.setPlaca(veiculoAtualizado.getPlaca());
        veiculo.setModelo(veiculoAtualizado.getModelo());
        veiculo.setCor(veiculoAtualizado.getCor());
        veiculo.setTipoVeiculo(veiculoAtualizado.getTipoVeiculo());

        return veiculoRepository.save(veiculo);
    }

    public void deletarVeiculo(Integer id) {
        veiculoRepository.deleteById(id);
    }
}