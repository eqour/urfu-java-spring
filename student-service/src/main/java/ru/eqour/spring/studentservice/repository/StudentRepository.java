package ru.eqour.spring.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eqour.spring.studentservice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
