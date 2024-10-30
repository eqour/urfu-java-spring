package ru.eqour.spring.lab2.service;

import org.junit.jupiter.api.Test;
import ru.eqour.spring.lab2.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class QuarterlyBonusServiceImplTest {

    @Test
    void calculate() {
        //given
        Positions position = Positions.PM;
        double bonus = 3.0;
        int workDays = 35;
        double salary = 100000.00;

        // when
        double result = new QuarterlyBonusServiceImpl().calculate(true, position, salary, bonus, workDays, 2023, 2);

        // then
        double expected = 1872000.0;
        assertThat(result).isEqualTo(expected);
    }
}