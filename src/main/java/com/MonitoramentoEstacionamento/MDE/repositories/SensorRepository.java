package com.MonitoramentoEstacionamento.MDE.repositories;

import com.MonitoramentoEstacionamento.MDE.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    // Adicione métodos personalizados, se necessário
}
