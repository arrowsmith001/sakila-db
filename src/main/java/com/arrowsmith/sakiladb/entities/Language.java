package com.arrowsmith.sakiladb.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "language")
@ToString
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer language_id;

    //@Column(columnDefinition = "char")
    public String name;

    public java.sql.Timestamp last_update;
}
