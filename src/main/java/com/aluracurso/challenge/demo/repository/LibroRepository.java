package com.aluracurso.challenge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<com.aluracurso.challenge.demo.model.DatosLibros, Long> {
    Optional<com.aluracurso.challenge.demo.model.DatosLibros> findByTitulo(String titulo);
}