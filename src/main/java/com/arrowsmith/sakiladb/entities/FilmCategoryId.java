package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class FilmCategoryId {

    private Integer film_id;
    private Integer category_id;
}
