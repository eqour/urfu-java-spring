package ru.eqour.spring.secondservice.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Systems {
    ERP("ERP"),
    CRM("CRM"),
    WMS("WMS"),
    FIRST_SERVICE("service-1");

    private final String name;

    Systems(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
