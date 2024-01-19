package com.bagabobs.sorcerer.application.domain.service;

import com.bagabobs.sorcerer.application.domain.model.Victim;
import com.bagabobs.sorcerer.application.domain.model.VictimInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VillageServiceTest {
    private VillageService villageService;

    @BeforeEach
    void init() {
        villageService = new VillageService(new Victim());
    }

    @Test
    void calculateAvgYearFromVictimGiveCorrectResult() {
        List<VictimInfo> victimInfos = new ArrayList<>();
        VictimInfo victimInfo1 = new VictimInfo(10, 12);
        victimInfos.add(victimInfo1);
        VictimInfo victimInfo2 = new VictimInfo(13, 17);
        victimInfos.add(victimInfo2);

        double result = villageService.calculateAvgYearFromVictim(victimInfos);

        assertThat(result).isEqualTo(4.5);
    }

    @Test
    void calculateAvgYearFromVictimAgeAtDeathIsMoreThenYearOfDeathWillReturnMinusOne() {
        List<VictimInfo> victimInfos = new ArrayList<>();
        VictimInfo victimInfo2 = new VictimInfo(10, 12);
        victimInfos.add(victimInfo2);
        VictimInfo victimInfo1 = new VictimInfo(12, 10);
        victimInfos.add(victimInfo1);

        double result = villageService.calculateAvgYearFromVictim(victimInfos);

        assertThat(result).isEqualTo(-1);
    }
}
