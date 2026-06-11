package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home() {
        return "Application is running successfully 🚀";
    }

    @GetMapping
    public List<Student> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return repo.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
