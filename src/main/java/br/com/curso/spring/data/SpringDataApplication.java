package br.com.curso.spring.data;

import  br.com.curso.spring.data.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.curso.spring.data.model.entity")
public class SpringDataApplication {

	@Autowired
	private CargoService cargoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}
}
