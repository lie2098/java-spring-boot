package com.lye.cruddemo;

import com.lye.cruddemo.entity.Instructor;
import com.lye.cruddemo.entity.InstructorDetail;
import com.lye.cruddemo.service.InstructorDetailService;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorDetailService instructorDetailService) {
        return runner -> {
//            saveInstructorDetail(instructorDetailService);
//            findInstructorDetailById(instructorDetailService);
            deleteInstructorDetailById(instructorDetailService);
        };
    }

    private void deleteInstructorDetailById(InstructorDetailService instructorDetailService) {
        System.out.println();
        System.out.println("deleting... instructor detail");

        int id = 2;

        instructorDetailService.deleteById(id);

        System.out.println("deleted instructor detail by id " + id);

    }

    private void saveInstructorDetail(InstructorDetailService instructorDetailService) {
        System.out.println("Saving... instructor");
        InstructorDetail instructorDetail = new InstructorDetail("@lieroar", "haiku");
        Instructor instructor = new Instructor("lye", "lie", "lie.lye@demo.com");

//      Need to add this annotation @ToString.Exclude in the entity to avoid issue in persisting the record
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
}
