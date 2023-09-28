package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "rental")
@ToString
@Getter
@Setter
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rental_id;
    private Timestamp rental_date;
    private Timestamp return_date;
    private Timestamp last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    private Integer inventory_inventory_id = 0;
    private Integer rentals_rental_id = 0;
}
