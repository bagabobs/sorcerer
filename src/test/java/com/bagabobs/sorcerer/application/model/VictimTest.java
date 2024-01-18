package com.bagabobs.sorcerer.application.model;

import com.bagabobs.sorcerer.application.domain.model.Victim;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class VictimTest {
    private Victim victim;

    @BeforeEach
    void init() {
        victim = new Victim();
    }

    @Test
    void getVictimByYearWillGetCorrectResultIfYearOfPowerIs4ThenResultIs7() {
        int victimAmount = victim.getVictimByYear(4);

        assertThat(victimAmount).isEqualTo(7);
    }

    @Test
    void getVictimByYearWillGetCorrectResultIfYearOfPowerIs5ThenResultIs12() {
        int victimAmount = victim.getVictimByYear(5);

        assertThat(victimAmount).isEqualTo(12);
    }

    @Test
    void getVictimByYearWillGetCorrectResultIfYearOfPowerIs1ThenResultIs1() {
        int victimAmount = victim.getVictimByYear(1);

        assertThat(victimAmount).isEqualTo(1);
    }

    @Test
    void getVictimByYearWillGetCorrectResultIfYearOfPowerIs3ThenResultIs4() {
        int victimAmount = victim.getVictimByYear(3);

        assertThat(victimAmount).isEqualTo(4);
    }
}
