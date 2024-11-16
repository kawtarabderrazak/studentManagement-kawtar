package com.example.student_management.controllers;
import com.example.student_management.entities.Student;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collection;
@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student savedStudent = studentService.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);


    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = studentService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll() {
        List <Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/count")
    public ResponseEntity<Long> countStudents() {
        Long count = studentService.countStudents();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    @GetMapping("/year")
    public ResponseEntity<List<Student>> findByYear() {
        List<Student> studentsByYear = (List<Student>) studentService.findNbrStudentByYear();
        return new ResponseEntity<>(studentsByYear, HttpStatus.OK);
    }



}
