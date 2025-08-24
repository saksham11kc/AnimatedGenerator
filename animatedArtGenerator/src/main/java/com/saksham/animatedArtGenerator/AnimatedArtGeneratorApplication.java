package com.saksham.animatedArtGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AnimatedArtGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimatedArtGeneratorApplication.class, args);
	}

}
