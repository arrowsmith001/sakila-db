package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer address_id;
    public String address;
    public String address2;
    public String district;
    public String postal_code;
    public String phone;

//    @JsonIgnore
//    public Blob location;

    public java.sql.Timestamp last_update;
    @ManyToOne
    @JoinColumn(name = "city_id")
    public City city;
}
