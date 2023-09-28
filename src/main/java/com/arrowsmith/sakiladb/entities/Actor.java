package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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
