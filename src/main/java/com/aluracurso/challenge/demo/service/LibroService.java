package com.aluracurso.challenge.demo.service;

import com.aluracurso.challenge.demo.model.AutorDTO;
import com.aluracurso.challenge.demo.model.DatosAutor;
import com.aluracurso.challenge.demo.model.DatosLibros;
import com.aluracurso.challenge.demo.model.Datos;
import com.aluracurso.challenge.demo.repository.AutorRepository;
import com.aluracurso.challenge.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private static final String URL_API = "https://gutendex.com/books/";

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private ConsumoApi consumoApi;

    @Autowired
    private ConvierteDatos convierteDatos;
    @Autowired
    private AutorRepository autorRepository;


    // 🔍 Buscar por título, desde BD o API
    public DatosLibros buscarLibroPorTitulo(String titulo) {
        Optional<DatosLibros> libroEnBD = libroRepository.findByTitulo(titulo);
        if (libroEnBD.isPresent()) {
            System.out.println("📚 Libro encontrado en la base de datos.");
            return libroEnBD.get();
        }

        System.out.println("🌐 Libro no encontrado — consultando API...");
        String json = consumoApi.obtenerDatos(URL_API + "?search=" + titulo.replace(" ", ""));
        Datos datos = convierteDatos.obtenerDatos(json, Datos.class);

        List<DatosLibros> libros = datos.resultado();
        if (!libros.isEmpty()) {
            DatosLibros libroEncontrado = libros.get(0);

            // 🔁 Transformar AutorDTO → DatosAutor
            List<AutorDTO> autoresDTO = libroEncontrado.getAuthors(); // ← este campo debe existir en DatosLibros
            List<DatosAutor> autoresConvertidos = autoresDTO.stream()
                    .map(dto -> {
                        DatosAutor autor = new DatosAutor();
                        autor.setNombre(dto.getNombre());
                        autor.setFechaDeNacimiento(dto.getFechaDeNacimiento());
                        return autor;
                    })
                    .toList();

            autoresConvertidos.forEach(autorRepository::save);
            libroEncontrado.setAutores(autoresConvertidos);
            libroRepository.save(libroEncontrado);

            System.out.println("💾 Libro guardado en BD.");
            return libroEncontrado;
        }

        System.out.println("🚫 Libro no encontrado ni en API.");
        return null;
    }



    // 📋 Listar todos los libros
    public List<DatosLibros> listarLibros() {
        return libroRepository.findAll();
    }


}