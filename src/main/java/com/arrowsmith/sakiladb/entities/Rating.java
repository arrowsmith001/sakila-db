package com.arrowsmith.sakiladb.entities;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum Rating {
    PG, G, NC_17, PG_13,R
}


@Converter
class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.name().replace("_", "-"); // Replace underscores with hyphens
    }

    @Override
    public Rating convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Rating.valueOf(dbData.replace("-", "_")); // Replace hyphens with underscores
    }
}