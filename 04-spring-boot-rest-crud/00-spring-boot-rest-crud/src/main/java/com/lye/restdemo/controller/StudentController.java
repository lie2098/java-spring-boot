package com.lye.restdemo.controller;

import com.lye.restdemo.model.Student;
import com.lye.restdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> students() {
        return studentService.getStudentList();
    }

    @GetMapping("/students/{index}")
    public Student studentByIndex(@PathVariable int index) {
        return studentService.getByIndex(index);
    }
}
