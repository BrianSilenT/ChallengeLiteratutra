package com.aluracurso.challenge.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class DatosLibros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonAlias("title")
    private String titulo;

    @JsonAlias("download_count")
    private Double numeroDeDescargas;

    @ElementCollection
    @JsonAlias("languages")
    private List<String> idiomas;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<com.aluracurso.challenge.demo.model.DatosAutor> autor;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private DatosAutor autors;

    // 👉 Constructor vacío para JPA
    public DatosLibros() {}


    // ✅ Getters y Setters
    // (puedes generarlos automáticamente si usas Lombok con @Getter @Setter)

    public List<String> getIdiomas() {
        return idiomas;
    }
    public String getTitulo() {
        return titulo;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }
}
