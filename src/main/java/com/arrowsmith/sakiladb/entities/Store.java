package com.arrowsmith.sakiladb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer store_id;

    public java.sql.Timestamp last_update;

    @ManyToOne
    @JoinColumn(name = "address_id")
    public Address address;

    @ManyToOne
    @JoinColumn(name = "manager_staff_id")
    @JsonIgnoreProperties({"store", "address"})
    public Staff manager;
}
