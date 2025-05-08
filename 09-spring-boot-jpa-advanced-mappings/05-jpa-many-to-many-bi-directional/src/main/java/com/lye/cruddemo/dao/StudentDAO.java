package com.lye.cruddemo.dao;

import com.lye.cruddemo.entity.Student;

public interface StudentDAO {
    Student findStudentAndCoursesByStudentId(int id);

    void updateStudent(Student student);

    void deleteStudent(Student student);
}
