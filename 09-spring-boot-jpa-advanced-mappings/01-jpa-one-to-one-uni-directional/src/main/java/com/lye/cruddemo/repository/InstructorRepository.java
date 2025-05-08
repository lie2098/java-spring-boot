package com.lye.cruddemo.repository;

import com.lye.cruddemo.dao.InstructorDAO;
import com.lye.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorRepository implements InstructorDAO {
    private final EntityManager entityManager;

    public InstructorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public void removeById(int id) {
        Instructor instructor = findById(id);

        entityManager.remove(instructor);
    }
}
