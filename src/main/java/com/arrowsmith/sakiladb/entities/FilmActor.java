package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "film_actor")
@ToString
@Getter
@Setter
public class FilmActor
{
    @EmbeddedId
    private FilmActorId id;

    private java.sql.Timestamp last_update;


}

