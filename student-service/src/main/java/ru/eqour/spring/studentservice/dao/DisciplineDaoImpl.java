package ru.eqour.spring.studentservice.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.eqour.spring.studentservice.entity.Discipline;

import java.util.List;

@Slf4j
@Repository
public class DisciplineDaoImpl implements DisciplineDao {

    private final EntityManager entityManager;

    public DisciplineDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Discipline> getAllDisciplines() {
        Query query = entityManager.createQuery("from Discipline");
        //noinspection unchecked
        List<Discipline> allDisciplines = query.getResultList();
        log.info("getAllDisciplines" + allDisciplines);
        return allDisciplines;
    }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) {
        return entityManager.merge(discipline);
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int id) {
        return entityManager.find(Discipline.class, id);
    }

    @Override
    @Transactional
    public void deleteDiscipline(int id) {
        Query query = entityManager.createQuery("delete from Discipline where id = :disciplineId");
        query.setParameter("disciplineId", id);
        query.executeUpdate();
    }
}
