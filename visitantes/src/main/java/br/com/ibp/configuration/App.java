package br.com.ibp.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="br.com.ibp.repository")
@EntityScan(basePackages="br.com.ibp.entity")
@EnableEurekaClient

public class App {
	
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
