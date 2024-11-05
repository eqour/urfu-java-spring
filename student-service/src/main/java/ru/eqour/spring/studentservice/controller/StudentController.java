package ru.eqour.spring.studentservice.controller;

import org.springframework.web.bind.annotation.*;
import ru.eqour.spring.studentservice.entity.Student;
import ru.eqour.spring.studentservice.model.OperationResult;
import ru.eqour.spring.studentservice.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public OperationResult<List<Student>> getAllStudents() {
        return new OperationResult<>(OperationResult.SUCCESS_MESSAGE, studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public OperationResult<Object> getStudent(@PathVariable("id") int id) {
        return new OperationResult<>(OperationResult.SUCCESS_MESSAGE, studentService.getStudent(id));
    }

    @PostMapping
    public OperationResult<Student> saveStudent(@RequestBody Student student) {
        return new OperationResult<>(OperationResult.SUCCESS_MESSAGE, studentService.saveStudent(student));
    }

    @PutMapping
    public OperationResult<Student> updateStudent(@RequestBody Student student) {
        return new OperationResult<>(OperationResult.SUCCESS_MESSAGE, studentService.saveStudent(student));
    }

    @DeleteMapping("/{id}")
    public OperationResult<Object> deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return new OperationResult<>(OperationResult.SUCCESS_MESSAGE, null);
    }

    @ExceptionHandler(Exception.class)
    public OperationResult<String> handleException(Exception e) {
        return new OperationResult<>(OperationResult.ERROR_MESSAGE, e.getMessage());
    }
}
