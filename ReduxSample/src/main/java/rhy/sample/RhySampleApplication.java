package rhy.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rhy.sample.common.init.ConfigurationLoader;

@SpringBootApplication
public class RhySampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhySampleApplication.class, args);
		
        new ConfigurationLoader().refreshConfiguration(); 
	}
}
