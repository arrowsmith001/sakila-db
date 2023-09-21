package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "inventory")
@ToString
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer inventory_id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    public Film film;

    @ManyToOne
    @JoinColumn(name = "store_id")
    public Store store;

    public java.sql.Timestamp last_update;

    @OneToMany(mappedBy = "inventory")
    @JsonIgnore
    public List<Rental> rentals;

    public Integer film_film_id = 0;
    public Integer inventories_inventory_id = 0;
}
