package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;


@Table(name = "film_text")
public class FilmText {

    public Integer film_id;
    public String title;
    public String description;
}
