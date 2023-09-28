package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Table(name = "country")
@ToString
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "country")
    private String countryName;

    @Column(name = "last_update")
    private Timestamp lastUpdate;
}
