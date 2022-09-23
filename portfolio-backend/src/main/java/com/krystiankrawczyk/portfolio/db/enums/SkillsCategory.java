package com.krystiankrawczyk.portfolio.db.enums;

public enum SkillsCategory {
    FRONTEND("Frontend Development"),
    BACKEND("Backend Development");

    private final String label;

    SkillsCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
