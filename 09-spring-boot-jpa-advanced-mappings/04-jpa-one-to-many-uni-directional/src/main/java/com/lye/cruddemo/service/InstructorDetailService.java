package com.lye.cruddemo.service;

import com.lye.cruddemo.dao.InstructorDetailDAO;
import com.lye.cruddemo.entity.InstructorDetail;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class InstructorDetailService {
    private final InstructorDetailDAO instructorDetailDAO;

    public InstructorDetailService(InstructorDetailDAO instructorDetailDAO) {
        this.instructorDetailDAO = instructorDetailDAO;
    }

    public InstructorDetail findById(int id) {
        return instructorDetailDAO.findById(id);
    }

    @Transactional
    public void save(InstructorDetail instructorDetail) {
        instructorDetailDAO.save(instructorDetail);
    }
}
