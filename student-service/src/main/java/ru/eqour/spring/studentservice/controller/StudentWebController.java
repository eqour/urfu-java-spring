package ru.eqour.spring.studentservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.eqour.spring.studentservice.entity.Student;
import ru.eqour.spring.studentservice.repository.StudentRepository;

import java.util.Optional;

@Controller
public class StudentWebController {

    private final StudentRepository studentRepository;

    public StudentWebController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/list")
    public ModelAndView getAllStudents() {
        ModelAndView mav = new ModelAndView("list-students");
        mav.addObject("students", studentRepository.findAll());
        return mav;
    }

    @GetMapping("/addStudentForm")
    public ModelAndView addStudentForm() {
        ModelAndView mav = new ModelAndView("add-student-form");
        mav.addObject("student", new Student());
        return mav;
    }

    @PostMapping("/saveStudent")
    public RedirectView saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return new RedirectView("list");
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Integer studentId) {
        ModelAndView mav = new ModelAndView("add-student-form");
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        mav.addObject("student", studentOptional.orElseGet(Student::new));
        return mav;
    }

    @GetMapping("/deleteStudent")
    public RedirectView deleteStudent(@RequestParam Integer studentId) {
        studentRepository.deleteById(studentId);
        return new RedirectView("list");
    }
}
