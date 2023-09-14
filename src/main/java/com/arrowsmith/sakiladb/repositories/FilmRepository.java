package com.arrowsmith.sakiladb.repositories;

import com.arrowsmith.sakiladb.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Short>
{

}
