package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer rental_id;
    public java.sql.Date rental_date;
    public java.sql.Date return_date;
    public java.sql.Timestamp last_update;


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
