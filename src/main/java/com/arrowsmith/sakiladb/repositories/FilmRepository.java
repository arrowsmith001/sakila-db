package com.arrowsmith.sakiladb.repositories;

import com.arrowsmith.sakiladb.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>
{

    @Query("SELECT f FROM Film f WHERE f.filmId IN (SELECT fc.id.filmId FROM FilmCategory fc WHERE fc.id.categoryId = :categoryId)")
    List<Film> findAllByCategory(Integer categoryId);

    @Query("SELECT f FROM Film f ORDER BY RAND() LIMIT :limit")
    List<Film> getRandomSelection(Integer limit);

    @Query("SELECT f FROM Film f JOIN f.inventories i JOIN i.rentals r GROUP BY f ORDER BY COUNT(r) DESC LIMIT :limit")
    List<Film> getPopularFilms(Integer limit);

    @Query("SELECT f FROM Film f WHERE UPPER(f.title) LIKE UPPER(CONCAT(:term,'%')) " +
            "ORDER BY " +
            "CASE WHEN UPPER(title) LIKE UPPER(CONCAT(:term,'%')) THEN 1 ELSE 2 END " +
            "LIMIT :limit")
    List<Film> getFilmsBySearchTerm(String term, Integer limit);
}
