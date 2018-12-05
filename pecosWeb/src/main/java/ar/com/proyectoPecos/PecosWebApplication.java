package ar.com.proyectoPecos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PecosWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecosWebApplication.class, args);
	}
}
