package com.MonitoramentoEstacionamento.MDE.repositories;

import com.MonitoramentoEstacionamento.MDE.entities.Andar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AndarRepository extends JpaRepository<Andar, Integer> {
    Andar findByDescricao(String descricao);
}