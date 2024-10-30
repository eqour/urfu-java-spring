package ru.eqour.spring.lab2.service;

import ru.eqour.spring.lab2.model.Positions;

public interface AnnualBonusService {

    double calculate(Positions position, double salary, double bonus, int workDays, int year);

}
