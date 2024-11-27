package com.MonitoramentoEstacionamento.MDE.services;

import com.MonitoramentoEstacionamento.MDE.entities.Vaga;
import com.MonitoramentoEstacionamento.MDE.repositories.VagaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VagaService {

    private final VagaRepository vagaRepository;

    public List<Vaga> listarVagas() {
        return vagaRepository.findAll();
    }

    public Vaga buscarPorId(Integer id) {
        return vagaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vaga não encontrada com o ID: " + id));
    }

    public List<Vaga> listarPorStatus(String status) {
        return vagaRepository.findByStatus(status);
    }

    public Vaga salvar(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    public Vaga atualizar(Integer id, Vaga vagaAtualizada) {
        Vaga vaga = buscarPorId(id);
        vaga.setNumeroVaga(vagaAtualizada.getNumeroVaga());
        vaga.setTipoVaga(vagaAtualizada.getTipoVaga());
        vaga.setStatus(vagaAtualizada.getStatus());
        vaga.setAndar(vagaAtualizada.getAndar());
        return vagaRepository.save(vaga);
    }

    public void deletar(Integer id) {
        Vaga vaga = buscarPorId(id);
        vagaRepository.delete(vaga);
    }
}
