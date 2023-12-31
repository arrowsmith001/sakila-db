package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

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
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "address")
    private String address1;

    private String address2;
    private String district;

    @Column(name = "postal_code")
    private String postalCode;

    private String phone;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties("address")
    private City city;


}
