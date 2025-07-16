package com.aluracurso.challenge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<com.aluracurso.challenge.demo.model.DatosAutor, Long> {
    List<com.aluracurso.challenge.demo.model.DatosAutor> findByFechaDeNacimientoLessThanEqual(Integer anio);

}
