package com.lye.cruddemo.repository;

import com.lye.cruddemo.dao.InstructorDAO;
import com.lye.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
    public void remove(Instructor instructor) {
        entityManager.remove(instructor);
    }

    @Override
    public Instructor findByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("FROM Instructor i " +
                "JOIN FETCH i.courses " +
                "JOIN FETCH i.instructorDetail " +
                "WHERE i.id = :id", Instructor.class);

        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public void deleteInstructor(Instructor instructor) {
        entityManager.remove(instructor);
    }
}
