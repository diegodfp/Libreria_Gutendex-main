package com.alurachallenge.LibreriaGutendex.repository;

import com.alurachallenge.LibreriaGutendex.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface
AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);

    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libros")
    List<Autor> libroAutor();

    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libros WHERE a.fechaDeNacimiento <= :year AND (a.fechaDeMuerte = 0 OR a.fechaDeMuerte >= :year)")
    List<Autor> autoresAnio(@Param("year") int year);

   /* @Query("SELECT a FROM Autor a WHERE a.birthDate <= :year AND (a.dateOfDeath = 0 OR a.dateOfDeath >= :year)")
    List<Autor> autoresAnio(@Param("year") int year);*/
}


