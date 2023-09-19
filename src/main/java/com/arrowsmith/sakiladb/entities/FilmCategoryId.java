package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class FilmCategoryId {

    public Integer film_id;
    public Integer category_id;
}
