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

    public Estacionamento save(Estacionamento estacionamento) {
        return estacionamentoRepository.save(estacionamento);
    }

    public List<Estacionamento> findAll() {
        return estacionamentoRepository.findAll();
    }

    public Optional<Estacionamento> findById(Integer id) {
        return estacionamentoRepository.findById(id);
    }

    public Optional<Estacionamento> update(Integer id, Estacionamento estacionamentoAtualizado) {
        return estacionamentoRepository.findById(id)
                .map(estacionamento -> {
                    estacionamento.setNomeEstacionamento(estacionamentoAtualizado.getNomeEstacionamento());
                    estacionamento.setEndereco(estacionamentoAtualizado.getEndereco());
                    estacionamento.setCapacidadeTotal(estacionamentoAtualizado.getCapacidadeTotal());
                    return estacionamentoRepository.save(estacionamento);
                });
    }

    public void deleteById(Integer id) {
        estacionamentoRepository.deleteById(id);
    }
}
