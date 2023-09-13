package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;


@Table(name = "film_actor")
public class FilmActor
{
    public Integer film_id;
    public Integer actor_id;
    public java.sql.Timestamp last_update;

}
