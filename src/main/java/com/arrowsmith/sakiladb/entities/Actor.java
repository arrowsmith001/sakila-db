package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "actor")
@ToString
@Getter
@Setter
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actor_id;

    private String first_name;
    private String last_name;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnoreProperties("actors")
    private List<Film> films;


    private Timestamp last_update;


}
