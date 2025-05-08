package com.lye.cruddemo.service;

import com.lye.cruddemo.dao.CourseDAO;
import com.lye.cruddemo.entity.Course;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    public final CourseDAO courseDAO;

    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public List<Course> findCoursesByInstructorId(int id) {
       return courseDAO.findCoursesByInstructorId(id);
    }

    @Transactional
    public void updateCourse(Course course) {
        courseDAO.update(course);
    }

    public Course findCourseById(int id) {
        return courseDAO.findById(id);
    }

    @Transactional
    public void deleteCourseById(int id) {
        courseDAO.deleteById(id);
    }

    @Transactional
    public void saveCourse(Course course) {
        courseDAO.saveCourse(course);
    }

    public Course findCourseAndReviewById(int id) {
        return courseDAO.findCourseAndReviewByCourseId(id);
    }
}
