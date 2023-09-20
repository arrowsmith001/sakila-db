package com.arrowsmith.sakiladb.repositories;

import com.arrowsmith.sakiladb.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>
{
    @Query("SELECT f FROM Film f WHERE f.film_id IN (SELECT fc.id.film_id FROM FilmCategory fc WHERE fc.id.category_id = :categoryId)")
    List<Film> findAllByCategory(Integer categoryId);

    //@Query
   // public List<Film> findByGenre(String genre);
}
