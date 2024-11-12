package org.hbrs.se1.ws24.uebung4;

import java.io.Serializable;

public class UserStory implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String acceptanceCriteria;
    private String project;
    private double businessValue;
    private double risk;
    private double priority;
    private double effort;
    private double prioritizationValue;

    public UserStory(int id, String title, String acceptanceCriteria, String project,
                     double businessValue, double risk, double priority, double effort) {
        if (businessValue < 0 || risk < 0 || priority < 0 || effort <= 0) {
            throw new IllegalArgumentException("Kennzahlen dürfen nicht negativ oder null sein.");
        }
        this.id = id;
        this.title = title;
        this.acceptanceCriteria = acceptanceCriteria;
        this.project = project;
        this.businessValue = businessValue;
        this.risk = risk;
        this.priority = priority;
        this.effort = effort;
        calculatePrioritization();
    }

    private void calculatePrioritization() {
        this.prioritizationValue = (businessValue + risk + priority) / effort;
    }

    public double getPrioritizationValue() {
        return prioritizationValue;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Titel: %s, Priorität: %.2f", id, title, prioritizationValue);
    }
}
