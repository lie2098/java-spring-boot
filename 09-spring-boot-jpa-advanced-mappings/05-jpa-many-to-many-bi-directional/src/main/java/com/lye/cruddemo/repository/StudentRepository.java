package com.lye.cruddemo.repository;

import com.lye.cruddemo.dao.StudentDAO;
import com.lye.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository implements StudentDAO {
    private final EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student s " +
                "JOIN FETCH s.courses " +
                "WHERE s.id = :id", Student.class);

        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }
}
