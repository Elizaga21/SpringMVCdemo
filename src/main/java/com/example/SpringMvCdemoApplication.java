package com.example;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Estudiante;
import com.example.entities.Facultad;
import com.example.entities.Telefono;
import com.example.entities.Estudiante.Genero;
import com.example.services.EstudianteService;
import com.example.services.FacultadService;
import com.example.services.TelefonoService;

@SpringBootApplication
public class SpringMvCdemoApplication implements CommandLineRunner {

	@Autowired
	private FacultadService facultadService;

	@Autowired
	private EstudianteService estudianteService;

	@Autowired
	private TelefonoService telefonoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvCdemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * Agregar registros de muestra, para Facultad, Estudiante y Telefono
		 */

		 facultadService.save(
			Facultad.builder()
			.nombre("Informática")
			.build());

		facultadService.save(
		Facultad.builder()
		.nombre("Biologia")
		.build());	

		estudianteService.save(
			Estudiante.builder()
			.nombre("Pedro")
			.primerApellido("Marcos")
			.segundoApellido("García")
			.fechaNacimiento(LocalDate.of(1975, 04, 21))
			.fechaAlta(LocalDate.of(1997, 06, 14))
			.beca(1900)
			.id(1)
			.genero(Genero.HOMBRE)
			.facultad(facultadService.findById(1))
			.build());

		telefonoService.save(
			Telefono.builder()
			.numero("74673927")
			.id(1)
			.estudiante(estudianteService.findById(1))
			.build());
	

	}

}
