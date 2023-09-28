package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Blob;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address")
@ToString
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer address_id;

    private String address;
    private String address2;
    private String district;
    private String postal_code;
    private String phone;

    @JsonIgnore
    private byte[] location = new byte[0];

    private Timestamp last_update;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties("address")
    private City city;
}
