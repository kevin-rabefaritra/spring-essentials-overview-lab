package io.spring.training.boot.jdbc_boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JdbcBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcBootApplication.class, args);
	}

	@Bean // can use @Bean thanks to @SpringBootApplication embedding @Configuration
	// Can inject JdbcTemplate because data source already created by Spring Boot
	CommandLineRunner commandLineRunner(JdbcTemplate jdbcTemplate) {
		String QUERY = "SELECT count(*) FROM T_ACCOUNT";
		// CommandLineRunner is a functionnal interface, so we can use lambda expression
		return args -> System.out.println(
			String.format("Hello, there are %s accounts", jdbcTemplate.queryForObject(QUERY, Long.class))
		);
	}
}
