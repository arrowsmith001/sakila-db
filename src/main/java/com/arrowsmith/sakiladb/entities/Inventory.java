package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "inventory")
@ToString
@Getter
@Setter
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventory_id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    private java.sql.Timestamp last_update;

    @OneToMany(mappedBy = "inventory")
    @JsonIgnore
    private List<Rental> rentals;

    private Integer film_film_id = 0;
    private Integer inventories_inventory_id = 0;
}
