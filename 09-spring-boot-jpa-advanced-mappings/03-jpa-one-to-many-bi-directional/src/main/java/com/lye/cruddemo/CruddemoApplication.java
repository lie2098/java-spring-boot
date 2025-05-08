package com.lye.cruddemo;

import com.lye.cruddemo.entity.Course;
import com.lye.cruddemo.entity.Instructor;
import com.lye.cruddemo.entity.InstructorDetail;
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
    public CommandLineRunner commandLineRunner(InstructorService instructorService,
                                               InstructorDetailService instructorDetailService,
                                               CourseService courseService) {
        return runner -> {
            saveInstructor(instructorService);
//            findInstructor(instructorService);

            saveInstructorDetail(instructorDetailService);
//            findInstructorDetailById(instructorDetailService);

//            createInstructorWithCourses(instructorService);

//            findInstructorWithCourses(instructorService, courseService);
//            findInstructorWithCoursesJoinFetch(instructorService);

//            updateInstructor(instructorService);
//            updateCourse(courseService);
//            deleteInstructor(instructorService);
//            deleteCourse(courseService);
        };
    }

    private void deleteCourse(CourseService courseService) {
        System.out.println();
        System.out.println("Deleting Course...");
        int id = 2;

        courseService.deleteCourseById(id);

        System.out.println("Deleted Course: " + id);
    }

    private void updateCourse(CourseService courseService) {
        System.out.println();
        System.out.println("--- updating course ---");

        int id = 1;

        Course course = courseService.findCourseById(id);
        course.setTitle("Pyshits");

        courseService.updateCourse(course);

        System.out.println("course updated...");
    }

    private void updateInstructor(InstructorService instructorService) {
        System.out.println();
        System.out.println("Update Instructor");

        int id = 2;

        Instructor instructor = instructorService.findById(id);

        instructor.setLastName("Lastu Naimu");

        instructorService.update(instructor);
    }

    private void findInstructorWithCoursesJoinFetch(InstructorService instructorService) {
        System.out.println();
        System.out.println("Find Instructor with Courses Join Fetch");
        int id = 2;

        Instructor instructor = instructorService.findByIdJoinFetch(id);
        displayInstructorDetails(instructor);
        displayCourses(instructor.getCourses());
    }

    private void findInstructorWithCourses(InstructorService instructorService, CourseService courseService) {
        int id = 2;

        System.out.println();
        System.out.println("Find instructor with courses -- id: " + id);

        Instructor instructor = instructorService.findById(id);
        List<Course> courses = courseService.findCoursesByInstructorId(instructor.getId());
        instructor.setCourses(courses);

        displayInstructorDetails(instructor);
        displayCourses(instructor.getCourses());
    }

    private void displayCourses(List<Course> course) {
        System.out.println("--- Course list ---");
        course.forEach(CruddemoApplication::printCourse);
    }

    private static void printCourse(Course course) {
        System.out.println("Title: " + course.getTitle());
    }

    private void createInstructorWithCourses(InstructorService instructorService) {
        System.out.println();
        System.out.println("Saving... instructor with Courses");

        Instructor instructor = new Instructor("ru", "le", "ru.le@demo.com");
        InstructorDetail instructorDetail = new InstructorDetail("@lieroar", "jcool");
        instructor.setInstructorDetail(instructorDetail);

        coursesBuilder(instructor);

        instructorService.save(instructor);

        System.out.println("Saved Instructor: " + instructor);
    }

    private void coursesBuilder(Instructor instructor) {
        Course course1 = new Course("Math");
        Course course2 = new Course("P.E");

        instructor.add(course1);
        instructor.add(course2);
    }

    private void saveInstructorDetail(InstructorDetailService instructorDetailService) {
        System.out.println("Saving... instructor");
        InstructorDetail instructorDetail = new InstructorDetail("@lieroar", "haiku");
        Instructor instructor = new Instructor("lye", "lie", "lie.lye@demo.com");

//      Need to add this annotation @ToString.Exclude in the entity to avoid issue Method threw 'java.lang.StackOverflowError' exception. Cannot evaluate cruddemo.entity.Instructor.toString()
//      or just add toString() and remove the instructor
        instructor.setInstructorDetail(instructorDetail); // Necessary for persistence: Instructor is the owning side with @JoinColumn.
        instructorDetail.setInstructor(instructor);     // Necessary for bidirectional navigation and object graph consistency.

        instructorDetailService.save(instructorDetail);
        System.out.println("Saved Instructor Detail: " + instructorDetail);
    }

    private void findInstructorDetailById(InstructorDetailService instructorDetailService) {
        System.out.println("findInstructorDetailById");
        int id = 4;
        InstructorDetail instructorDetail = instructorDetailService.findById(id);

        displayInstructorDetails(instructorDetail);
    }

    private static void displayInstructorDetails(InstructorDetail instructorDetails) {
        System.out.println("========Instructor Details========");
        System.out.println("id: " + instructorDetails.getInstructor().getId());
        System.out.println("first name: " + instructorDetails.getInstructor().getFirstName());
        System.out.println("last name: " + instructorDetails.getInstructor().getLastName());
        System.out.println("email: " + instructorDetails.getInstructor().getEmail());
        System.out.println("youtube channel: " + instructorDetails.getYoutubeChannel());
        System.out.println("hobby: " + instructorDetails.getHobby());
    }

    private void deleteInstructor(InstructorService instructorService) {

        System.out.println();
        System.out.println("--- Delete Instructor by ID ---");
        int id = 2;

        instructorService.deleteById(id);

        System.out.println("Deleted Instructor with ID: " + id);
    }

    private void findInstructor(InstructorService instructorService) {
        System.out.println();
        System.out.println("--- Find Instructor by ID ---");
        int id = 1;
        Instructor instructor = instructorService.findById(id);

        if (ObjectUtils.isEmpty(instructor)) {
            System.out.println("Instructor with ID: " + id + " not found");
            return;
        }

        displayInstructorDetails(instructor);
    }

    private static void displayInstructorDetails(Instructor instructor) {
        System.out.println("========Instructor Details========");
        System.out.println("id: " + instructor.getId());
        System.out.println("first name: " + instructor.getFirstName());
        System.out.println("last name: " + instructor.getLastName());
        System.out.println("email: " + instructor.getEmail());
        System.out.println("youtube channel: " + instructor.getInstructorDetail().getYoutubeChannel());
        System.out.println("hobby: " + instructor.getInstructorDetail().getHobby());
    }

    private void saveInstructor(InstructorService instructorService) {
        System.out.println("Saving... instructor");
        Instructor instructor = new Instructor("lye", "lie", "lie.lye@demo.com");
        InstructorDetail instructorDetail = new InstructorDetail("@lieroar", "haiku");
        instructor.setInstructorDetail(instructorDetail);

        instructorService.save(instructor);

        System.out.println("Saved Instructor: " + instructor);
    }
}
