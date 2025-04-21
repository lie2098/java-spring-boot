package com.lye.cruddemo.repository;

import com.lye.cruddemo.dao.StudentDAO;
import com.lye.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void saveAll(List<Student> students) {
        students.forEach(this::save);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student findByIdPersistence(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    public List<Student> findAllByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:lastName", Student.class);
        query.setParameter("lastName", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }

    @Override
    @Transactional
    public void resetPKValue() {
        entityManager.createNativeQuery("ALTER SEQUENCE student_id_seq RESTART WITH 1").executeUpdate();
    }
}
