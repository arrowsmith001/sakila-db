package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Blob;

@Entity
@Table(name = "staff")
@ToString
@Getter
@Setter
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staff_id;
    private String first_name;
    private String last_name;
    private Blob picture;
    private String email;
    private Boolean active;
    private String username;
    private String password;
    private java.sql.Timestamp last_update;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
