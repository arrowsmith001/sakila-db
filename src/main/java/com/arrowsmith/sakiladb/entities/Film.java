package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "film")
public class Film
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer film_id;
    private String title;
    private String description;


    private Date release_year; //private Integer release_year;
    private Byte rental_duration; //private Integer rental_duration;
    private BigDecimal rental_rate;
    private Short length; //private Integer length;
    private BigDecimal replacement_cost;

    @Column(columnDefinition = "enum (Types#CHAR)")
    public String rating;

    @Column(columnDefinition = "set")
    private String special_features;

    private Timestamp last_update; //private Date last_update;


    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    @JsonIgnoreProperties("films")
    private List<Actor> actors;


//    @OneToMany(
//            mappedBy = "film",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    public List<FilmActor> actors;


    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonIgnoreProperties("films")
    private List<Category> categories;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

}


