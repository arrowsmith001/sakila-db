package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "category")
@ToString
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnoreProperties("categories")
    private List<Film> films;


    private String name;
    private java.sql.Timestamp last_update;
}
