package com.lye.cruddemo;

import com.lye.cruddemo.dao.StudentDAO;
import com.lye.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            deleteAllStudent(studentDAO);
            studentDAO.resetPKValue();

            Student student = createStudent(studentDAO);
            displayStudent(studentDAO, student.getId());

            createStudents(studentDAO);
            displayAllStudent(studentDAO);

            displayStudentByLastName(studentDAO, "La");
            displayStudentByLastName(studentDAO, "Hem");

            updateStudent(studentDAO);

            deleteStudent(studentDAO);
            displayAllStudent(studentDAO);

            deleteAllStudent(studentDAO);
            displayAllStudent(studentDAO);
        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println();
        System.out.println("---Deleting all students---");
        int count = studentDAO.deleteAll();
        System.out.println("Deleted " + count + " students");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println();
        System.out.println("---Deleting Student with id: " + studentId);

        studentDAO.deleteById(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println();
        System.out.println("Updating Student with id: " + studentId);
        Student student = studentDAO.findById(studentId);

        System.out.println("current student: " + student);
        student.setFirstName("John");

        studentDAO.update(student);

        Student updatedStudent = studentDAO.findByIdPersistence(studentId);
        System.out.println("updated student: " + updatedStudent);
    }

    private void displayStudentByLastName(StudentDAO studentDAO, String lastName) {
        System.out.println();
        System.out.println("---Displaying All Student with Last Name: " + lastName);
        List<Student> students = studentDAO.findAllByLastName(lastName);
        students.forEach(System.out::println);
    }

    private void displayAllStudent(StudentDAO studentDAO) {
        System.out.println();
        System.out.println("---Displaying All Students---");
        List<Student> studentList = studentDAO.findAll();
        studentList.forEach(System.out::println);
    }

    private void displayStudent(StudentDAO studentDAO, int id) {
        System.out.println();
        System.out.println("Get student by id: " + id);

        Student student = studentDAO.findById(id);
        System.out.println("---Student's Details---");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Email: " + student.getEmail());
    }

    private Student createStudent(StudentDAO studentDAO) {
        System.out.println();
        System.out.println("Creating student...");
        Student student = new Student("Delie", "La", "delie.la@demo.com");
        studentDAO.save(student);

        System.out.println("Student added, id: " + student.getId());

        return student;
    }

    private void createStudents(StudentDAO studentDAO) {
        Student student1 = new Student("La", "La", "la.la@demo.com");
        Student student2 = new Student("May", "Hem", "may.hem@demo.com");
        Student student3 = new Student("Ham", "Beardger", "ham.beardger@demo.com");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        studentDAO.saveAll(studentList);
    }
}
