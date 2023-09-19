package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    @EmbeddedId
    public FilmCategoryId id;

    public java.sql.Timestamp last_update;
}
