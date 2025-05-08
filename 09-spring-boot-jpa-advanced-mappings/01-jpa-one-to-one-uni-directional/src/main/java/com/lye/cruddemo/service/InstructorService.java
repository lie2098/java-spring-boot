package com.lye.cruddemo.service;

import com.lye.cruddemo.dao.InstructorDAO;
import com.lye.cruddemo.entity.Instructor;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    private final InstructorDAO instructorDAO;

    public InstructorService(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Transactional
    public void save(Instructor instructor) {
        instructorDAO.save(instructor);
    }

    public Instructor findById(int id) {
        return instructorDAO.findById(id);
    }

    @Transactional
    public void deleteById(int id) {
        instructorDAO.removeById(id);
    }
}
