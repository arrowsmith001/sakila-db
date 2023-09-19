package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer actor_id;

    public String first_name;
    public String last_name;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnoreProperties("actors")
    public List<Film> films;


//    @OneToMany(
//            mappedBy = "actor",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    @OnDelete(action = OnDeleteAction.RESTRICT)
//    private List<FilmActor> films;


    public java.sql.Timestamp last_update;


//    @PreRemove
//    private void removeActorsFromFilms() {
//        for(Film f : films)
//        {
//            f.getActors().remove(this);
//        }
//    }
}
