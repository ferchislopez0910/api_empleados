package com.parameta.api.empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EnableAutoConfiguration
public class EmpleadosApiApplication {

	//TODO: hacer el contexto global de /api/empleados 
	public static void main(String[] args) {
		SpringApplication.run(EmpleadosApiApplication.class, args);
	}

}
