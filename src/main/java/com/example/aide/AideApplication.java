package com.example.aide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "com.example.aide.repository")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class AideApplication {

	public static void main(String[] args) {
		SpringApplication.run(AideApplication.class, args);
	}

}
