package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer inventory_id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    public Film film;

    @ManyToOne
    @JoinColumn(name = "store_id")
    public Store store;

    public java.sql.Timestamp last_update;
}
