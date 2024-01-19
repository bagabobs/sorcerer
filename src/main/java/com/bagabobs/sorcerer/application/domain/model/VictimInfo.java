package com.bagabobs.sorcerer.application.domain.model;

public class VictimInfo {
    private int ageAtDeath;
    private int yearOfDeath;

    public VictimInfo(int ageAtDeath, int yearOfDeath) {
        this.ageAtDeath = ageAtDeath;
        this.yearOfDeath = yearOfDeath;
    }

    public int getAgeAtDeath() {
        return ageAtDeath;
    }

    public void setAgeAtDeath(int ageAtDeath) {
        this.ageAtDeath = ageAtDeath;
    }

    public int getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(int yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }
}
