package com.aluracurso.challenge.demo.service;

public interface IConvierteDatos {
    <T> T obtenerDatos (String json, Class <T> clase);
}
