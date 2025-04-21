package com.lye.cruddemo.dao;

import com.lye.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    void saveAll(List<Student> students);

    Student findById(int id);
    Student findByIdPersistence(int id);

    List<Student> findAll();

    List<Student> findAllByLastName(String lastName);

    void update(Student student);

    void deleteById(int id);

    int deleteAll();

    void resetPKValue();
}
