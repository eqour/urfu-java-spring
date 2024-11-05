package ru.eqour.spring.studentservice.service;

import ru.eqour.spring.studentservice.entity.Discipline;

import java.util.List;

public interface DisciplineService {

    List<Discipline> getAllDisciplines();
    Discipline saveDiscipline(Discipline discipline);
    Discipline getDiscipline(int id);
    void deleteDiscipline(int id);
}
