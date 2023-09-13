package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

@Table(name = "film_category")
public class FilmCategory {
    public Integer film_id;
    public Integer category_id;

    public java.sql.Timestamp last_update;
}
