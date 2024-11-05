package ru.eqour.spring.studentservice.service;

import ru.eqour.spring.studentservice.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudent(int id);
    void deleteStudent(int id);
}
