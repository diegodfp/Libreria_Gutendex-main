package com.alurachallenge.LibreriaGutendex.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToMany(fetch = FetchType.LAZY) //
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;

   // private List<String> lenguajes;

    @Column(name = "lenguajes")
    private String lenguajes;


    private Double numeroDescargas;

    public Libro() {
    }

    public Libro(DatosLibros datosLibros, List<Autor> autores) {
        this.titulo = datosLibros.titulo();
        this.autores = autores;
        this.lenguajes = String.join(",", datosLibros.idioma());
        this.numeroDescargas = datosLibros.numeroDeDescargas();
    }

    // Método para obtener el primer idioma
   /* public String getPrimerLenguaje() {
        return lenguajes != null && !lenguajes.isEmpty() ? lenguajes.get(0) : null;
    }*/

    public String getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(String lenguajes) {
        this.lenguajes = lenguajes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

   /* public List<String> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<String> lenguajes) {
        this.lenguajes = lenguajes;
    }*/

    public Double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        String auresNomgre = autores.stream()
                .map(Autor::getNombre)
                .collect(Collectors.joining());

        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", lenguajes=" + lenguajes +
                ", numeroDescargas=" + numeroDescargas +
                '}';
    }

    // Método para obtener el primer idioma
   /* public String getPrimerLenguaje() {
        return lenguajes != null && !lenguajes.isEmpty() ? lenguajes.get(0) : null;
    }*/
}
