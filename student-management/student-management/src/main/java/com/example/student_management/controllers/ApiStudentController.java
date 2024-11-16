package com.example.student_management.controllers;

import com.example.student_management.entities.Student;
import com.example.student_management.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/students")  // Préfixe "/api" pour l'API REST
public class ApiStudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Récupérer tous les étudiants")
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.findAll();  // Récupérer tous les étudiants
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @Operation(summary = "Récupérer le nombre total d'étudiants")
    @GetMapping("/count")
    public ResponseEntity<Long> countStudents() {
        long count = studentService.countStudents();  // Récupérer le nombre d'étudiants
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @Operation(summary = "Récupérer les étudiants par année")
    @GetMapping("/byYear")
    public ResponseEntity<Collection<?>> findStudentsByYear() {
        Collection<?> studentsByYear = studentService.findNbrStudentByYear();  // Récupérer les étudiants par année
        return new ResponseEntity<>(studentsByYear, HttpStatus.OK);
    }

    @Operation(summary = "Créer un nouvel étudiant")
    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.save(student);  // Enregistrer un nouvel étudiant
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @Operation(summary = "Supprimer un étudiant")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
        boolean deleted = studentService.delete(id);  // Supprimer un étudiant par ID
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
