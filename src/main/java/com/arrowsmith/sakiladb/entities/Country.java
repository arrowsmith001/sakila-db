package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer country_id;
    public String country;
    public java.sql.Timestamp last_update;
}
