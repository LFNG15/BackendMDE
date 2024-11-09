package com.MonitoramentoEstacionamento.MDE.services;

import com.MonitoramentoEstacionamento.MDE.entities.Estacionamento;
import com.MonitoramentoEstacionamento.MDE.repositories.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public Estacionamento salvarEstacionamento(Estacionamento estacionamento) {
        return estacionamentoRepository.save(estacionamento);
    }

    public List<Estacionamento> listarTodos() {
        return estacionamentoRepository.findAll();
    }

    public Optional<Estacionamento> buscarPorId(Integer id) {
        return estacionamentoRepository.findById(id);
    }

    public Estacionamento atualizarEstacionamento(Integer id, Estacionamento estacionamentoAtualizado) {
        Estacionamento estacionamento = estacionamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado"));

        estacionamento.setNomeEstacionamento(estacionamentoAtualizado.getNomeEstacionamento());
        estacionamento.setEndereco(estacionamentoAtualizado.getEndereco());
        estacionamento.setCapacidadeTotal(estacionamentoAtualizado.getCapacidadeTotal());

        return estacionamentoRepository.save(estacionamento);
    }

    public void deletarEstacionamento(Integer id) {
        estacionamentoRepository.deleteById(id);
    }
}
