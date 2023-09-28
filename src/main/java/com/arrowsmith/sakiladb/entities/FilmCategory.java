package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "film_category")
@ToString
@Getter
@Setter
public class FilmCategory {

    @EmbeddedId
    private FilmCategoryId id;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;
}
