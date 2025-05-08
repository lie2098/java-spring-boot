package com.lye.cruddemo;

import com.lye.cruddemo.entity.Course;
import com.lye.cruddemo.entity.Instructor;
import com.lye.cruddemo.entity.InstructorDetail;
import com.lye.cruddemo.entity.Review;
import com.lye.cruddemo.service.CourseService;
import com.lye.cruddemo.service.InstructorDetailService;
import com.lye.cruddemo.service.InstructorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ObjectUtils;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CourseService courseService) {
        return runner -> {
            createCourseAndReviews(courseService);
            findCourseAndReview(courseService);
            deleteCourse(courseService);
        };
    }

    private void findCourseAndReview(CourseService courseService) {
        System.out.println();
        System.out.println("--- find course and review ---");
        int id = 3;

        Course course = courseService.findCourseAndReviewById(id);

        displayCourseAndReviews(course);
    }

    private void displayCourseAndReviews(Course course) {
        System.out.println("--- Course Details ---");
        System.out.println("id: " + course.getId());
        System.out.println("title:" + course.getTitle());

        System.out.println("--- Reviews ---");
        course.getReviews().forEach(item -> System.out.println(item.getComment()));
    }

    private void createCourseAndReviews(CourseService courseService) {
        Course course = new Course("Java Spring Boot Demo Course");

        course.addReview(new Review("Learned much!"));
        course.addReview(new Review("Great course"));
        course.addReview(new Review("it's not good, difficult to comprehend"));

        courseService.saveCourse(course);
    }

    private void deleteCourse(CourseService courseService) {
        System.out.println();
        System.out.println("Deleting Course...");
        int id = 5;

        courseService.deleteCourseById(id);

        System.out.println("Deleted Course: " + id);
    }
}
