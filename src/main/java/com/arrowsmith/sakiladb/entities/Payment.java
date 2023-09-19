package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer payment_id;

    public BigDecimal amount;
    public Timestamp payment_date;
    public Timestamp last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;


    @ManyToOne
    @JoinColumn(name = "staff_id")
    public Staff staff;


    @ManyToOne
    @JoinColumn(name = "rental_id")
    public Rental rental;
}
