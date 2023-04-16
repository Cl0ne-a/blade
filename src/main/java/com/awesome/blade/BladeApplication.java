package com.awesome.blade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class BladeApplication {

	public static void main(String[] args) {
		var timestamp = LocalDateTime.now();
		SpringApplication.run(BladeApplication.class, args);
	}
}
