package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FilmActorId implements Serializable {

    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Integer film_id;
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Integer actor_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorId that = (FilmActorId) o;
        return Objects.equals(film_id, that.film_id) && Objects.equals(actor_id, that.actor_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(film_id, actor_id);
    }
}
