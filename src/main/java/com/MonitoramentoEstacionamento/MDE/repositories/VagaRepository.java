package com.MonitoramentoEstacionamento.MDE.repositories;

import com.MonitoramentoEstacionamento.MDE.entities.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer> {
    // Adicione métodos personalizados, se necessário
}
