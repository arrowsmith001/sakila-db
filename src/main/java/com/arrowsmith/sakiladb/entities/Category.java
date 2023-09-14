package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Byte category_id;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnoreProperties("categories")
    public List<Film> films;


    public String name;
    public java.sql.Timestamp last_update;
}
