package com.MonitoramentoEstacionamento.MDE.repositories;

import com.MonitoramentoEstacionamento.MDE.entities.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Integer> {
    // Adicione métodos personalizados, se necessário
}
