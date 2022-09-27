package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080
    @GetMapping("/student")
    public Student getStudent() {
        return new Student("peter", "Gichuki");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mary", "Gichuki"));
        students.add(new Student("Yvonne", "Gichuki"));
        students.add(new Student("Vale", "Gichuki"));
        students.add(new Student("Rehab", "Gichuki"));
        students.add(new Student("Sam", "Gichuki"));

        return students;
    }

    @GetMapping("{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,
                                       @PathVariable("lastName") String lastName){
        return new Student(firstName,lastName);
    }
    /*
    rest API for handling query parameters
    http://localhost:8080/student_name?firstName=mary&lastName=gichuki

     */
    @GetMapping("/student_name")
    public Student studentQueryParam(@RequestParam(name = "firstName") String firstName,
                                     @RequestParam (name = "lastName")String lastName){
        return new Student(firstName,lastName);
    }
}
