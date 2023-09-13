package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer actor_id;

    public String first_name;
    public String last_name;

    @ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY)
    public List<Film> films;

    public java.sql.Timestamp last_update;
}
