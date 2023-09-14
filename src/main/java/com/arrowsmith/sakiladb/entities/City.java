package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "city")
public class City
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Short city_id;
    public String city;
    public java.sql.Timestamp last_update;

    @OneToMany(mappedBy = "city")
    public List<Address> address;
}
