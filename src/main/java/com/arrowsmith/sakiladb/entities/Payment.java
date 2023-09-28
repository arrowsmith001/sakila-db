package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "payment")
@ToString
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentId;

    private BigDecimal amount;

    @Column(name = "payment_date")
    private Timestamp paymentDate;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;


    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
