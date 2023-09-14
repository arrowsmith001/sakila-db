package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Short actor_id;

    public String first_name;
    public String last_name;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnoreProperties("actors")
    public List<Film> films;

    public java.sql.Timestamp last_update;
}
