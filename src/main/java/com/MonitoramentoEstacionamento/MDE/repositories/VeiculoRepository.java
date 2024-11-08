package com.MonitoramentoEstacionamento.MDE.repositories;

import com.MonitoramentoEstacionamento.MDE.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    // Adicione métodos personalizados, se necessário
}
