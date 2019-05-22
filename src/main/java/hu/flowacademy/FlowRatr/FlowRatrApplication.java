package hu.flowacademy.FlowRatr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FlowRatrApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowRatrApplication.class, args);
	}

}
