package com.lye.cruddemo.dao;

import com.lye.cruddemo.entity.InstructorDetail;

public interface InstructorDetailDAO {
    InstructorDetail findById(int id);

    void save(InstructorDetail instructorDetail);

    void deleteById(int id);
}
