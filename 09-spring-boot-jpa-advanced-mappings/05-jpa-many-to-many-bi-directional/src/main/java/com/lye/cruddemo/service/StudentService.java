package com.lye.cruddemo.service;

import com.lye.cruddemo.dao.StudentDAO;
import com.lye.cruddemo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class StudentService {
    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Student findStudentAndCoursesByStudentId(int id) {
        return studentDAO.findStudentAndCoursesByStudentId(id);
    }

    @Transactional
    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    @Transactional
    public void deleteStudentById(int id) {
        Student student = studentDAO.findStudentAndCoursesByStudentId(id);

        if (ObjectUtils.isEmpty(student)) {
            throw new RuntimeException("Student not found By Id: " + id);
        }

        student.getCourses().forEach(course -> course.getStudents().remove(student));

        studentDAO.deleteStudent(student);
    }
}
