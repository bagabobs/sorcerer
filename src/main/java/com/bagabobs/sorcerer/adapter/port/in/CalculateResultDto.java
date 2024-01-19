package com.bagabobs.sorcerer.adapter.port.in;

import com.bagabobs.sorcerer.application.domain.model.VictimInfo;

import java.util.List;

public class CalculateResultDto {
    private List<VictimInfo> victimList;
    private double avgYearOfDeath;

    public CalculateResultDto(List<VictimInfo> victimList, double avgYearOfDeath) {
        this.victimList = victimList;
        this.avgYearOfDeath = avgYearOfDeath;
    }

    public List<VictimInfo> getVictimList() {
        return victimList;
    }

    public void setVictimList(List<VictimInfo> victimList) {
        this.victimList = victimList;
    }

    public double getAvgYearOfDeath() {
        return avgYearOfDeath;
    }

    public void setAvgYearOfDeath(double avgYearOfDeath) {
        this.avgYearOfDeath = avgYearOfDeath;
    }
}
