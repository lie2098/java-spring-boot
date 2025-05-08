package com.lye.cruddemo.dao;

import com.lye.cruddemo.entity.Instructor;

public interface InstructorDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void removeById(int id);
}
