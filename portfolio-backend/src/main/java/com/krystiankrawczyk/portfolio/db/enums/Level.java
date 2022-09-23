package com.krystiankrawczyk.portfolio.db.enums;

public enum Level {
    BASIC("Basic"),
    INTERMEDIATE("Intermediate"),
    EXPERIENCED("Experienced");

    private final String label;

    Level(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
