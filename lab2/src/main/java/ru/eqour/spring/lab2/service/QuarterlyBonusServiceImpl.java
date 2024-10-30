package ru.eqour.spring.lab2.service;

import org.springframework.stereotype.Service;
import ru.eqour.spring.lab2.model.Positions;

import java.time.Year;

@Service
public class QuarterlyBonusServiceImpl implements QuarterlyBonusService {

    @Override
    public double calculate(boolean isManager, Positions position, double salary, double bonus, int workDays, int year, int quarter) {
        if (!isManager) {
            throw new IllegalArgumentException("Квартальная премия рассчитывается только для менеджеров");
        }
        int daysInYearQuarter = getCountDaysInYearQuarter(year, quarter);
        return salary * bonus * daysInYearQuarter * position.getPositionCoefficient() / workDays;
    }

    private int getCountDaysInYearQuarter(int year, int quarter) {
        if (quarter < 1 || quarter > 4) {
            throw new IllegalArgumentException("Номер квартала должен быть от 1 до 4 включительно");
        }
        int answer = 0;
        int startMonth = (quarter - 1) * 3 + 1;
        int endMonth = startMonth + 2;
        for (int month = startMonth; month <= endMonth; month++) {
            answer += Year.of(year).atMonth(month).lengthOfMonth();
        }
        return answer;
    }
}
