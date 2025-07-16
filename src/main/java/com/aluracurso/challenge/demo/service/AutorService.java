package com.aluracurso.challenge.demo.service;

import com.aluracurso.challenge.demo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // 📋 Listar todos los autores registrados
    public List<com.aluracurso.challenge.demo.model.DatosAutor> listarAutores() {
        return autorRepository.findAll();
    }

    // 🔍 Buscar autores vivos en cierto año
    public List<com.aluracurso.challenge.demo.model.DatosAutor> autoresVivosHasta(int anioLimite) {
        return autorRepository.findByFechaDeNacimientoLessThanEqual(anioLimite);
    }
}