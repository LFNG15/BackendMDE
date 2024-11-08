package com.MonitoramentoEstacionamento.MDE.repositories;

import com.MonitoramentoEstacionamento.MDE.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Adicione métodos personalizados, se necessário
}
