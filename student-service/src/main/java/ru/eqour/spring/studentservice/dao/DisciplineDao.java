package ru.eqour.spring.studentservice.dao;

import org.springframework.stereotype.Repository;
import ru.eqour.spring.studentservice.entity.Discipline;

import java.util.List;

@Repository
public interface DisciplineDao {

    List<Discipline> getAllDisciplines();
    Discipline saveDiscipline(Discipline discipline);
    Discipline getDiscipline(int id);
    void deleteDiscipline(int id);
}
