package com.lye.restdemo.service;

import com.lye.restdemo.exception.StudentNotFoundException;
import com.lye.restdemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Lie", "Sol"));
        studentList.add(new Student("Say", "Pan"));
        studentList.add(new Student("L", "MAO"));

        return studentList;
    }

    public Student getByIndex(int index) {
        List<Student> students = getStudentList();

        if (index >= students.size() || index < 0) {
            throw new StudentNotFoundException("Student Not Found! index: " + index);
        }

        return students.get(index);
    }
}
