package com.MonitoramentoEstacionamento.MDE.services;

import com.MonitoramentoEstacionamento.MDE.entities.Cliente;
import com.MonitoramentoEstacionamento.MDE.entities.Veiculo;
import com.MonitoramentoEstacionamento.MDE.exceptions.UserNotFoundException;
import com.MonitoramentoEstacionamento.MDE.exceptions.VeiculoJaCadastradoException;
import com.MonitoramentoEstacionamento.MDE.repositories.ClienteRepository;
import com.MonitoramentoEstacionamento.MDE.repositories.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ClienteRepository clienteRepository;

    public Veiculo associarVeiculoAoCliente(Integer clienteId, Veiculo veiculo) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new UserNotFoundException("Cliente não encontrado"));
        if (veiculoRepository.existsByPlacaAndCliente_ClienteId(veiculo.getPlaca(), clienteId)) {
            throw new VeiculoJaCadastradoException("Veículo com essa placa já cadastrado para esse cliente");
        }

        veiculo.setCliente(cliente);
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> buscarVeiculosDoCliente(Integer clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new UserNotFoundException("Cliente não encontrado"));

        return veiculoRepository.findByCliente_ClienteId(clienteId);
    }

    public Veiculo atualizarVeiculo(Integer clienteId, Integer veiculoId, Veiculo veiculo) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new UserNotFoundException("Cliente não encontrado"));

        Veiculo veiculoExistente = veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        if (!veiculoExistente.getPlaca().equals(veiculo.getPlaca()) &&
                veiculoRepository.existsByPlacaAndCliente_ClienteId(veiculo.getPlaca(), clienteId)) {
            throw new VeiculoJaCadastradoException("Veículo com essa placa já cadastrado para o cliente");
        }

        veiculoExistente.setPlaca(veiculo.getPlaca());
        veiculoExistente.setModelo(veiculo.getModelo());
        veiculoExistente.setCor(veiculo.getCor());
        veiculoExistente.setTipoVeiculo(veiculo.getTipoVeiculo());

        return veiculoRepository.save(veiculoExistente);
    }
}
