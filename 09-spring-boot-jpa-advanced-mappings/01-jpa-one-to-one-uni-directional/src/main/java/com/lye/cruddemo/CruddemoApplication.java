package com.lye.cruddemo;

import com.lye.cruddemo.entity.Instructor;
import com.lye.cruddemo.entity.InstructorDetail;
import com.lye.cruddemo.service.InstructorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ObjectUtils;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorService instructorService) {
        return runner -> {
            saveInstructor(instructorService);
            findInstructorById(instructorService);
            deleteInstructorById(instructorService);
        };
    }

    private void deleteInstructorById(InstructorService instructorService) {

        System.out.println();
        System.out.println("--- Delete Instructor by ID ---");
        int id = 1;

        instructorService.deleteById(id);

        System.out.println("Deleted Instructor with ID: " + id);
    }

    private void findInstructorById(InstructorService instructorService) {
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
