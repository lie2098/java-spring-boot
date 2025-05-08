package com.lye.cruddemo.repository;

import com.lye.cruddemo.dao.InstructorDetailDAO;
import com.lye.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDetailRepository implements InstructorDetailDAO {
    private final EntityManager entityManager;

    public InstructorDetailRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public InstructorDetail findById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    public void save(InstructorDetail instructorDetail) {
        entityManager.persist(instructorDetail);
    }
}
