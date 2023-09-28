package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "language")
@ToString
@Getter
@Setter
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Integer languageId;

    private String name;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;
}
