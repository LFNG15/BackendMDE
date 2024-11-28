package com.MonitoramentoEstacionamento.MDE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.MonitoramentoEstacionamento.MDE.infra.security")
public class MdeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdeApplication.class, args);
	}

}
