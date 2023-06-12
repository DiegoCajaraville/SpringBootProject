package com.teleco.gestor_servicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.teleco.gestor_servicios.entities")
public class GestorServiciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorServiciosApplication.class, args);
	}

}
