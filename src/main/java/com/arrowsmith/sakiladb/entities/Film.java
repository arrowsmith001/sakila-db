package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "film")
public class Film
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer film_id;
    public String title;
    public String description;
    public Integer release_year;
    public Integer rental_duration;
    public BigDecimal rental_rate;
    public Integer length;
    public BigDecimal replacement_cost;
    public String rating;
    public String special_features;
    public java.sql.Date last_update;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    public List<Actor> actors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    public List<Category> categories;

    @ManyToOne
    @JoinColumn(name = "language_id")
    public Language language;

    @ManyToOne
    @JoinColumn(name = "original_language_id")
    public Language originalLanguage;

    public String getTitle() {
        return title;
    }
}


