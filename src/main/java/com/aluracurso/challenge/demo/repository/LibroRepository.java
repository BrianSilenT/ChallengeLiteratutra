package com.aluracurso.challenge.demo.repository;

import com.aluracurso.challenge.demo.model.DatosLibros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<com.aluracurso.challenge.demo.model.DatosLibros, Long> {
    List<DatosLibros>findByTituloIgnoreCaseContains(String titulo);
}