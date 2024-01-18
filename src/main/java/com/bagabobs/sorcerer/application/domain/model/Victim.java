package com.bagabobs.sorcerer.application.domain.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Victim {

    public int getVictimByYear(int yearOfPower) {
        int[] arrInd = new int[yearOfPower];

        int prevYear = 0;
        arrInd[0] = 1;
        for(int i = 1; i < yearOfPower; i++) {
            arrInd[i] = arrInd[i-1] + prevYear;
            prevYear = arrInd[i-1];
        }
        return Arrays.stream(arrInd).sum();
    }
}
