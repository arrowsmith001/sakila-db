package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FilmActorId {

    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Integer film_id;
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Integer actor_id;

}
