package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer rental_id;
    public Timestamp rental_date;
    public Timestamp return_date;
    public Timestamp last_update;


    @ManyToOne
    @JoinColumn(name = "inventory_id")
    public Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    public Staff staff;
}
