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
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;

    @OneToMany(mappedBy = "inventory")
    @JsonIgnore
    private List<Rental> rentals;

    @Column(name = "film_film_id")
    private Integer filmFilmId = 0;

    @Column(name = "inventories_inventory_id")
    private Integer inventoriesInventoryId = 0;
}
