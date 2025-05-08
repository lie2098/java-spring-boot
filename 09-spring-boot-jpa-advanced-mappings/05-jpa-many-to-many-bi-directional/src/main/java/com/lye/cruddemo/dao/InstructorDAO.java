package com.lye.cruddemo.dao;

import com.lye.cruddemo.entity.Instructor;

public interface InstructorDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void remove(Instructor instructor);

    Instructor findByIdJoinFetch(int id);

    void update(Instructor instructor);

    void deleteInstructor(Instructor instructor);
}
