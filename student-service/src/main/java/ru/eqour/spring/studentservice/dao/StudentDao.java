package ru.eqour.spring.studentservice.dao;

import org.springframework.stereotype.Repository;
import ru.eqour.spring.studentservice.entity.Student;

import java.util.List;

@Repository
public interface StudentDao {

    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudent(int id);
    void deleteStudent(int id);
}
