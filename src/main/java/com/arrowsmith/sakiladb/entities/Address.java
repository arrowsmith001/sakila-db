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
    private Integer address_id;

    @Column(name = "address")
    private String address1;
    
    private String address2;
    private String district;
    private String postal_code;
    private String phone;

    private Timestamp last_update;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties("address")
    private City city;


}
