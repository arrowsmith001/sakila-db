package com.arrowsmith.sakiladb.repositories;

import com.arrowsmith.sakiladb.entities.Film;
import com.arrowsmith.sakiladb.entities.FilmActor;
import com.arrowsmith.sakiladb.entities.FilmActorId;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId>
{
    @Modifying
    @Transactional
    @Query("DELETE FROM FilmActor fa WHERE fa.id.film_id=:id")
    void deleteByFilmId(Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM FilmActor fa WHERE fa.id.actor_id=:id")
    void deleteByActorId(Integer id);
}

