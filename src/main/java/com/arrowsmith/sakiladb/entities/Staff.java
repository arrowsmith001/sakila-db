package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Byte staff_id;
    public String first_name;
    public String last_name;
    public Blob picture;
    public String email;
    public Integer active;
    public String username;
    public String password;
    public java.sql.Timestamp last_update;

    @ManyToOne
    @JoinColumn(name = "address_id")
    public Address address;

    @ManyToOne
    @JoinColumn(name = "store_id")
    public Store store;
}
