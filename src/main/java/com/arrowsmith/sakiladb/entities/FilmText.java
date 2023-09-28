package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Table(name = "film_text")
@ToString
@Getter
@Setter
public class FilmText {

    @Column(name = "film_id")
    private Integer filmId;

    private String title;
    private String description;
}
