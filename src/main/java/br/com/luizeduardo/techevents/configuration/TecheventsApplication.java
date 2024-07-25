package br.com.luizeduardo.techevents.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class TecheventsApplication {

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "development");
		SpringApplication.run(WebServerConfig.class, args);
	}

}
