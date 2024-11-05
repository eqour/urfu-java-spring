package ru.eqour.spring.studentservice.service;

import org.springframework.stereotype.Service;
import ru.eqour.spring.studentservice.dao.StudentDao;
import ru.eqour.spring.studentservice.entity.Student;
import ru.eqour.spring.studentservice.exception.EntityNotFoundException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public Student getStudent(int id) {
        Student student = studentDao.getStudent(id);
        if (student == null) {
            throw new EntityNotFoundException("Не удалось найти студента с id '" + id + "'");
        }
        return studentDao.getStudent(id);
    }

    @Override
    public void deleteStudent(int id) {
        Student student = studentDao.getStudent(id);
        if (student == null) {
            throw new EntityNotFoundException("Не удалось найти студента с id '" + id + "'");
        }
        studentDao.deleteStudent(id);
    }
}
