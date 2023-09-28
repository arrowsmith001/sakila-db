package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "city")
@ToString
@Getter
@Setter
public class City
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer city_id;

    @Column(name = "city")
    private String city_name;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;

    @OneToMany(mappedBy = "city")
    private List<Address> address;
}
