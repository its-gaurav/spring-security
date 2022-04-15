package demo.security.controllers;

import demo.security.dto.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentRestController {

    private static List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Jack Jones"),
            new Student(2, "Daniels Sen"),
            new Student(3, "Harry Potter"),
            new Student(4, "Hermoinee"),
            new Student(5, "Chandan Veer")
    );

    @GetMapping("{studentId}")
    public Student findById(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(s-> s.getId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist"));
    }

    @PostMapping()
    public Student addStudent(@RequestBody Student student){
        int lastId = STUDENTS.get(STUDENTS.size()-1).getId();
        STUDENTS.add(new Student(lastId+1, student.getName()));
        return STUDENTS.get(STUDENTS.size()-1);
    }

}
