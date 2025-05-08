package com.lye.cruddemo.dao;

import com.lye.cruddemo.entity.Course;

import java.util.List;

public interface CourseDAO {
    List<Course> findCoursesByInstructorId(int id);

    void update(Course course);

    Course findById(int id);

    void deleteById(int id);

    void saveCourse(Course course);

    Course findCourseAndReviewByCourseId(int id);

    Course findCourseAndStudentByCourseId(int id);
}
