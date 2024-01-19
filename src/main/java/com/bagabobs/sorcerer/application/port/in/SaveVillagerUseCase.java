package com.bagabobs.sorcerer.application.port.in;

import com.bagabobs.sorcerer.application.domain.model.VictimInfo;

import java.util.List;

public interface SaveVillagerUseCase {
    double calculateAvgYearFromVictim(List<VictimInfo> victimInfos);
}
