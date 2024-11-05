package ru.eqour.spring.studentservice.controller;

import org.springframework.web.bind.annotation.*;
import ru.eqour.spring.studentservice.entity.Discipline;
import ru.eqour.spring.studentservice.model.OperationResult;
import ru.eqour.spring.studentservice.service.DisciplineService;

import java.util.List;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public OperationResult<List<Discipline>> getAllDisciplines() {
        return new OperationResult<>(OperationResult.SUCCESS_MESSAGE, disciplineService.getAllDisciplines());
    }

    @GetMapping("/{id}")
    public OperationResult<Object> getDiscipline(@PathVariable("id") int id) {
        return new OperationResult<>(OperationResult.SUCCESS_MESSAGE, disciplineService.getDiscipline(id));
    }

    @PostMapping
    public OperationResult<Discipline> saveDiscipline(@RequestBody Discipline discipline) {
        return new OperationResult<>(OperationResult.SUCCESS_MESSAGE, disciplineService.saveDiscipline(discipline));
    }

    @PutMapping
    public OperationResult<Discipline> updateDiscipline(@RequestBody Discipline discipline) {
        return new OperationResult<>(OperationResult.SUCCESS_MESSAGE, disciplineService.saveDiscipline(discipline));
    }

    @DeleteMapping("/{id}")
    public OperationResult<Object> deleteDiscipline(@PathVariable("id") int id) {
        disciplineService.deleteDiscipline(id);
        return new OperationResult<>(OperationResult.SUCCESS_MESSAGE, null);
    }

    @ExceptionHandler(Exception.class)
    public OperationResult<String> handleException(Exception e) {
        return new OperationResult<>(OperationResult.ERROR_MESSAGE, e.getMessage());
    }
}
