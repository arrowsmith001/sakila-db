package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer payment_id;

    public BigDecimal amount;
    public java.sql.Date payment_date;
    public java.sql.Timestamp last_update;

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
