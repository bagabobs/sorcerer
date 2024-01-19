package com.bagabobs.sorcerer.application.domain.service;

import com.bagabobs.sorcerer.application.domain.model.Victim;
import com.bagabobs.sorcerer.application.domain.model.VictimInfo;
import com.bagabobs.sorcerer.application.port.in.SaveVillagerUseCase;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VillageService implements SaveVillagerUseCase {
    private final Victim victim;

    public VillageService(Victim victim) {
        this.victim = victim;
    }

    @Override
    public double calculateAvgYearFromVictim(List<VictimInfo> victimInfos) {
        assert !victimInfos.isEmpty();
        int totalYear = 0;
        for(VictimInfo victimInfo : victimInfos) {
            int subtractYear = victimInfo.getYearOfDeath() - victimInfo.getAgeAtDeath();
            if(subtractYear > 0) {
                int yearOfSorcerer = victim.getVictimsNumberByYear(subtractYear);
                totalYear += yearOfSorcerer;
            } else {
                return -1.0;
            }
        };
        return (double) totalYear/victimInfos.size();
    }
}
