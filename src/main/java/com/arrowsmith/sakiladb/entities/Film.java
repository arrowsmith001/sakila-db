package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "film")
public class Film
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer film_id;
    public String title;
    public String description;


    public Date release_year; //private Integer release_year;
    public Byte rental_duration; //private Integer rental_duration;
    public BigDecimal rental_rate;
    public Short length; //private Integer length;
    public BigDecimal replacement_cost;

    //@Column(columnDefinition = "enum (Types#CHAR)")
    public String rating;

    //@Column(columnDefinition = "set")
    public String special_features;

    public Timestamp last_update; //private Date last_update;


    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    @JsonIgnoreProperties("films")
    public List<Actor> actors;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonIgnoreProperties("films")
    public List<Category> categories;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "language_id")
    public Language language;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "original_language_id")
    public Language originalLanguage;


    @OneToMany(mappedBy = "film")
    @JsonIgnore
    public List<Inventory> inventories;

}


