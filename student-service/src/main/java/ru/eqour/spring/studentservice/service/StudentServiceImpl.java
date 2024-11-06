package ru.eqour.spring.studentservice.service;

import org.springframework.stereotype.Service;
import ru.eqour.spring.studentservice.entity.Student;
import ru.eqour.spring.studentservice.exception.EntityNotFoundException;
import ru.eqour.spring.studentservice.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getStudent(int id) {
        Optional<Student> student = repository.findById(id);
        if (student.isEmpty()) {
            throw new EntityNotFoundException("Не удалось найти студента с id '" + id + "'");
        }
        return student.get();
    }

    @Override
    public void deleteStudent(int id) {
        Optional<Student> student = repository.findById(id);
        if (student.isEmpty()) {
            throw new EntityNotFoundException("Не удалось найти студента с id '" + id + "'");
        }
        repository.deleteById(id);
    }
}
