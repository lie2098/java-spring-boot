package com.lye.cruddemo.service;

import com.lye.cruddemo.dao.InstructorDAO;
import com.lye.cruddemo.entity.Course;
import com.lye.cruddemo.entity.Instructor;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

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
        Instructor instructor = instructorDAO.findById(id);
        removeInstructorInCourse(instructor);

        instructorDAO.remove(instructor);
    }

    private static void removeInstructorInCourse(Instructor instructor) {
        List<Course> courses = instructor.getCourses().stream().map(removeInstructor()).toList();

        instructor.setCourses(courses);
    }

    private static Function<Course, Course> removeInstructor() {
        return course -> {
            course.setInstructor(null);
            return course;
        };
    }

    public Instructor findByIdJoinFetch(int id) {
        return instructorDAO.findByIdJoinFetch(id);
    }

    @Transactional
    public void update(Instructor instructor) {
        instructorDAO.update(instructor);
    }
}
