package br.com.barbero.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan (basePackages = "br.com.barbero")
@EnableJpaRepositories(basePackages="br.com.barbero.repository")
@EntityScan(basePackages="br.com.barbero.entity")
public class Configuration extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Configuration.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Configuration.class, args);
	}

}