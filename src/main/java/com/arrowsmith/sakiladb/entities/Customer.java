package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer customer_id;
    public String first_name;
    public String last_name;
    public String email;

    public Boolean active; //public Integer active;
    public java.sql.Timestamp create_date; //public java.sql.Date create_date;
    public java.sql.Timestamp last_update;


    @ManyToOne
    @JoinColumn(name = "address_id")
    public Address address;

    @ManyToOne
    @JoinColumn(name = "store_id")
    public Store store;
}
