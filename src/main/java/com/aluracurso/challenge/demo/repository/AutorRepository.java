package com.aluracurso.challenge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<com.aluracurso.challenge.demo.model.DatosAutor, Long> {
    List<com.aluracurso.challenge.demo.model.DatosAutor> findByFechaDeNacimientoLessThanEqual(Integer anio);

}
