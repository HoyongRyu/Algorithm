package rhy.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rhy.sample.common.init.ConfigurationLoader;

@SpringBootApplication
public class RhySampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhySampleApplication.class, args);
		
		System.out.println("!@# System Properties : (spring.profiles.active, " + System.getProperty("spring.profiles.active") 
        + "), (bas.home.dir"+ "," + System.getProperty("bas.home.dir") + ")");
        
        new ConfigurationLoader().refreshConfiguration(); 
	}
}
