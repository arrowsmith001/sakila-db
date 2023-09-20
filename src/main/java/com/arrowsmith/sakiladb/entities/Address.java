package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Blob;

@Entity
@Table(name = "address")
@Setter
@Getter
@ToString
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
    @JsonIgnoreProperties("address")
    public City city;
}
