package com.lye.cruddemo.repository;

import com.lye.cruddemo.dao.CourseDAO;
import com.lye.cruddemo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository  implements CourseDAO {
    private final EntityManager entityManager;

    public CourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("FROM Course c WHERE c.instructor.id = :id", Course.class);
        query.setParameter("id", id);

        return query.getResultList();
    }

    @Override
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void deleteById(int id) {
        Course course = findById(id);

        entityManager.remove(course);
    }

    @Override
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("FROM Course c " +
                "JOIN FETCH c.reviews " +
                "WHERE c.id = :id", Course.class);

        query.setParameter("id", id);

        return query.getSingleResult();
    }
}
