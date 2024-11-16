package com.example.student_management.service;
import com.example.student_management.entities.Student;
import com.example.student_management.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public boolean delete(int id){
        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findById(id));
        if(studentOptional.isPresent()){
            studentRepository.delete(studentOptional.get());
            return true;


        }else {
            return false;
        }
    }
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    public long countStudents(){
        return studentRepository.count();
    }
    public Collection<?> findNbrStudentByYear(){
        return studentRepository.findNbrStudentByYear();
    }
}
