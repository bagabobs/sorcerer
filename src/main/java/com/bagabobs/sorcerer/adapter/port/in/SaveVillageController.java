package com.bagabobs.sorcerer.adapter.port.in;

import com.bagabobs.sorcerer.application.domain.model.VictimInfo;
import com.bagabobs.sorcerer.application.port.in.SaveVillagerUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaveVillageController {
    private final SaveVillagerUseCase saveVillagerUseCase;

    public SaveVillageController(SaveVillagerUseCase saveVillagerUseCase) {
        this.saveVillagerUseCase = saveVillagerUseCase;
    }

    @PostMapping("/api/village/calculateaverage")
    public ResponseEntity<CalculateResultDto> calculateResult(@RequestBody List<VictimInfo> victimInfos) {
        if(victimInfos.isEmpty()) {
            throw new RuntimeException();
        }
        double resultOfCalculation = saveVillagerUseCase.calculateAvgYearFromVictim(victimInfos);
        CalculateResultDto calculateResultDto = new CalculateResultDto(victimInfos, resultOfCalculation);
        return ResponseEntity.ok().body(calculateResultDto);
    }
}
