package com.aluracurso.challenge.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DatosAutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonAlias("authors")
    private String nombre;
    @JsonAlias("birth_year")
    private Integer fechaDeNacimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatosLibros> libros = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public List<DatosLibros> getLibros() {
        return libros;
    }

    @Override
    public String toString() {
        return "DatosAutor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", libros=" + libros +
                '}';
    }
}