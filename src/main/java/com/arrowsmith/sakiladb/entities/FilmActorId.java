package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Embeddable
@ToString
@Getter
@Setter
public class FilmActorId {

    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Integer film_id;
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Integer actor_id;

}
