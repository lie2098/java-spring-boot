package com.lye.cruddemo;

import com.lye.cruddemo.entity.Course;
import com.lye.cruddemo.entity.Review;
import com.lye.cruddemo.entity.Student;
import com.lye.cruddemo.service.CourseService;
import com.lye.cruddemo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CourseService courseService,
                                               StudentService studentService) {
        return runner -> {
//            createCourseAndStudent(courseService);
//            findCourseAndStudent(courseService);
            addCoursesForStudent(studentService);
//            findStudentAndCourse(studentService);
//            deleteCourse(courseService);
            deleteStudent(studentService);
        };
    }

    private void deleteStudent(StudentService studentService) {
        System.out.println();
        System.out.println("--- deleting student ---");

        int id = 13;

        studentService.deleteStudentById(id);

        System.out.println("student with id " + id + " has been deleted successfully!");
    }

    private void addCoursesForStudent(StudentService studentService) {
        int id = 11;
        System.out.println();
        System.out.println("--- adding courses to student id: " + id + "---");

        Student student = studentService.findStudentAndCoursesByStudentId(id);
        addCoursesForStudent(student);

        studentService.updateStudent(student);

        System.out.println("student course updated...");
    }

    private void addCoursesForStudent(Student student) {
        student.addCourse(new Course("Gwenchana"));
        student.addCourse(new Course("Haleluya"));
    }

    private void findStudentAndCourse(StudentService studentService) {
        System.out.println();
        System.out.println("--- find student and course by student id ---");

        int id = 5;

        Student student = studentService.findStudentAndCoursesByStudentId(id);
        displayStudent(student);
        displayCourses(student.getCourses());

    }

    private void displayCourses(List<Course> courses) {
        System.out.println("--- Course details ---");
        courses.forEach(CruddemoApplication::displayCourse);
    }

    private void findCourseAndStudent(CourseService courseService) {
        int id = 7;
        System.out.println();
        System.out.println("--- find course and student by course id ---");
        Course course = courseService.findCourseAndStudentById(id);


        System.out.println("--- Course details ---");
        displayCourse(course);
        displayStudents(course.getStudents());
    }

    private static void displayCourse(Course course) {
        System.out.println("id: " + course.getId());
        System.out.println("title: " + course.getTitle());
    }

    private void displayStudents(List<Student> students) {
        students.forEach(CruddemoApplication::displayStudent);
    }

    private static void displayStudent(Student student) {
        System.out.println("--- Student details ---");
        System.out.println("student id: " + student.getId());
        System.out.println("first name: " + student.getFirstName());
        System.out.println("last name: " + student.getLastName());
        System.out.println("email: " + student.getEmail());
    }

    private void createCourseAndStudent(CourseService courseService) {
        System.out.println("Creating course and student");
        Course course = new Course("Spring Boot Course");
        addStudent(course);

        System.out.println("saving course: " + course);
        System.out.println("saving student: " + course.getStudents());
        courseService.saveCourse(course);
    }

    private static void addStudent(Course course) {
        Student student1 = new Student("Lye", "Roar", "lie.roar@demo.com");
        Student student2 = new Student("Naru", "Hudo", "naru.hudo@demo.com");
        Student student3 = new Student("Waka", "Ranaii", "waka.ranaii@demo.com");

        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);
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
        int id = 7  ;

        courseService.deleteCourseById(id);

        System.out.println("Deleted Course: " + id);
    }
}
