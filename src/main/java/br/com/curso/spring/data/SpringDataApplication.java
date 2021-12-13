package br.com.curso.spring.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = "br.com.curso.spring.data.model.entity")
@EnableJpaRepositories
public class SpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}
}
