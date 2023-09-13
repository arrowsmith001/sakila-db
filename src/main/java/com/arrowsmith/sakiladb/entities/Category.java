package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    public List<Film> films;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer category_id;

    public String name;
    public java.sql.Timestamp last_update;
}
