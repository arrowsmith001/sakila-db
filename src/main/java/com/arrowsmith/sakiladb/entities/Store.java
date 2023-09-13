package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer store_id;
    public Integer address_id;
    public java.sql.Timestamp last_update;


    @ManyToOne
    @JoinColumn(name = "manager_staff_id")
    public Staff manager;
}
