package com.alurachallenge.LibreriaGutendex.model;

public enum Idiomas {
    EN("en", "Inglés"),
    ES("es", "Español"),
    FR("fr", "Francés"),
    PT("pt", "Portugués");

    private final String codigo;
    private final String descripcion;

    Idiomas(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion + " [" + codigo + "]";
    }
}
