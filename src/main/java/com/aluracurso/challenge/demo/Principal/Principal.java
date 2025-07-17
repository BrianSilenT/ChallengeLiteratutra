package com.aluracurso.challenge.demo.principal;

import com.aluracurso.challenge.demo.model.DatosLibros;
import com.aluracurso.challenge.demo.model.DatosAutor;
import com.aluracurso.challenge.demo.service.LibroService;
import com.aluracurso.challenge.demo.service.AutorService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final Scanner teclado = new Scanner(System.in);
    private final LibroService libroService;
    private final AutorService autorService;

    public Principal(LibroService libroService, AutorService autorService) {
        this.libroService = libroService;
        this.autorService = autorService;
    }

    public void muestraElMenu() {
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("""
                📚 MENÚ PRINCIPAL
                1. Buscar libro por título
                2. Listar todos los libros registrados
                3. Listar todos los autores registrados
                4. Listar autores vivos en un año específico
                5. Salir
                """);

            try {
                opcion = teclado.nextInt();
                teclado.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Entrada inválida. Usa números para las opciones.");
                teclado.nextLine(); // limpiar input malformado
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.print("📖 Ingresa el título del libro: ");
                    String titulo = teclado.nextLine();
                    DatosLibros libro = libroService.buscarLibroPorTitulo(titulo);

                    if (libro != null) {
                        System.out.println("✅ Resultado:");
                        System.out.println("Título: " + libro.getTitulo());
                        System.out.println("Idiomas: " + libro.getIdiomas());
                        System.out.println("Descargas: " + libro.getNumeroDeDescargas());
                    } else {
                        System.out.println("❌ Libro no encontrado.");
                    }
                }

                case 2 -> {
                    List<DatosLibros> libros = libroService.listarLibros();
                    System.out.println("📚 Libros registrados:");
                    libros.forEach(libro -> System.out.println("- " + libro.getTitulo()));
                }

                case 3 -> {
                    List<DatosAutor> autores = autorService.listarAutores();
                    System.out.println("🧑‍🏫 Autores registrados:");
                    autores.forEach(autor -> System.out.println("- " + autor.getNombre()));
                }

                case 4 -> {
                    System.out.print("🎯 Ingrese el año límite: ");
                    int anio = teclado.nextInt();
                    teclado.nextLine(); // limpia buffer

                    List<DatosAutor> vivos = autorService.autoresVivosHasta(anio);
                    System.out.println("🫀 Autores nacidos hasta " + anio + ":");
                    vivos.forEach(autor -> System.out.println("- " + autor.getNombre() + " (" + autor.getFechaDeNacimiento() + ")"));
                }

                case 5 -> System.out.println("👋 ¡Gracias por usar la app! Hasta pronto.");
                default -> System.out.println("⚠️ Opción inválida, intenta de nuevo.");
            }

            System.out.println(); // espacio entre ciclos
        }
    }
}