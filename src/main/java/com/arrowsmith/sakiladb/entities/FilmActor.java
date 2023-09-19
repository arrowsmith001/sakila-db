package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "film_actor")
public class FilmActor
{
    @EmbeddedId
    public FilmActorId id;

    public java.sql.Timestamp last_update;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("film_id")
//    private Film film;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("actor_id")
//    private Actor actor;
//

}

