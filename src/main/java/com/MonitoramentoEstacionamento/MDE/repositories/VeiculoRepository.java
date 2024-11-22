package com.MonitoramentoEstacionamento.MDE.repositories;

import com.MonitoramentoEstacionamento.MDE.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    List<Veiculo> findByCliente_ClienteId(Integer clienteId);
    boolean existsByPlacaAndCliente_ClienteId(String placa, Integer clienteId);
}
