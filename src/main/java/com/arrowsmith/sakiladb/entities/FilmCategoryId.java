package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@ToString
@Getter
@Setter
public class FilmCategoryId {

    private Integer film_id;
    private Integer category_id;
}
