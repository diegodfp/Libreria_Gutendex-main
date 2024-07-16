package com.alurachallenge.LibreriaGutendex.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table (name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer fechaDeNacimiento;
    private Integer fechaDeMuerte;

    @ManyToMany(mappedBy = "autores", fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(){}

    public Autor(DatosAutor datosAutor){
        this.nombre = datosAutor.nombre();
        this.fechaDeNacimiento = datosAutor.fechaDeNacimiento();
        this.fechaDeMuerte = datosAutor.fechaDeMuerte();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeMuerte() {
        return fechaDeMuerte;
    }

    public void setFechaDeMuerte(Integer fechaDeMuerte) {
        this.fechaDeMuerte = fechaDeMuerte;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        String listaLibros = libros != null ? libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", ")) : "Ninguno";
        return "----- Autor -----\n" +
                "Nombre: " + nombre + "\n" +
                "Año de Nacimiento: " + fechaDeNacimiento + "\n" +
                "Año de Fallecimiento: " + fechaDeMuerte + "\n" +
                "Libros: " + listaLibros;
    }

    /*@Override
    public String toString() {
        String listaLibros = libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", "));
        return "----- Autor -----\n" +
                "Nombre: " + nombre + "\n" +
                "Año de Nacimiento: " + fechaDeNacimiento + "\n" +
                "Año de Fallecimiento: " + fechaDeMuerte + "\n" +
                "Libros: " + listaLibros;
    }*/
}
