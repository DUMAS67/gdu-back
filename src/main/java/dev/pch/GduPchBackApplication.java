package dev.pch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* Classe qui démarre en Spring Boot l'application GDU */
@SpringBootApplication
public class GduPchBackApplication {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PATCH", "PUT", "OPTIONS")
						.allowCredentials(true);
				;
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(GduPchBackApplication.class, args);
	}

}