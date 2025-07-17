# 📚 Gestor de Libros - Challenge Alura Java & Spring Boot

![Java](https://img.shields.io/badge/Java-17+-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-blueviolet)
![Estado](https://img.shields.io/badge/Estado-En%20Desarrollo-yellow)

Aplicación backend desarrollada en Java con Spring Boot que permite buscar libros mediante la API de [Gutendex](https://gutendex.com/), guardar la información en una base de datos PostgreSQL, vincular autores automáticamente, y acceder a los datos a través de un menú interactivo por consola.

---

## 🧪 Tecnologías principales

- Java 17+
- Spring Boot 3
- JPA & Hibernate
- PostgreSQL
- Maven
- Jackson (deserialización avanzada con @JsonAlias)
- Gutendex API (fuente externa)

---

# 🚀 Cómo ejecutar

## 1. Clona el repositorio:

bash
git clone https://github.com/BrianSilenT/ChallengeLiteratutra.git
cd gestor-libros

## 2. Configura tu base de datos
spring.datasource.url=jdbc:postgresql://localhost:5432/libros_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

## 3. ejecuta la aplicacion
./mvnw spring-boot:run

# 📖 Uso del menú
Al iniciar la app, verás en consola:
📚 MENÚ PRINCIPAL
1. Buscar libro por título
2. Listar todos los libros registrados
3. Listar todos los autores registrados
4. Listar autores vivos en un año específico
5. Salir
