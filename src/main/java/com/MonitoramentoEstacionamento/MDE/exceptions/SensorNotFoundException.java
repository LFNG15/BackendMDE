package com.MonitoramentoEstacionamento.MDE.exceptions;


public class SensorNotFoundException extends RuntimeException {
    public SensorNotFoundException(String message) {
        super(message);
    }
}
