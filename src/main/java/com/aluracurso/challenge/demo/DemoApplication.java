package com.aluracurso.challenge.demo;

import com.aluracurso.challenge.demo.principal.Principal;
import com.aluracurso.challenge.demo.service.AutorService;
import com.aluracurso.challenge.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private LibroService libroService;

	@Autowired
	private AutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Principal principal = new Principal(libroService, autorService);
		principal.muestraElMenu();
	}


}