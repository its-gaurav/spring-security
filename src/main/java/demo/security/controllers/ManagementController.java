package demo.security.controllers;

import demo.security.dto.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class ManagementController {

    private static List<Student> STUDENTS = new ArrayList<>(Arrays.asList(
            new Student(1, "Jack Jones"),
            new Student(2, "Daniels Sen"),
            new Student(3, "Harry Potter"),
            new Student(4, "Hermionee"),
            new Student(5, "Chandan Veer")
    ));

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents(){
        return STUDENTS;
    }
    @PostMapping()
    @PreAuthorize("hasAuthority('student:write')")
    public Student registerStudent(@RequestBody Student student){
        System.out.println("registerStudent");
        int lastId = STUDENTS.get(STUDENTS.size()-1).getId();
        STUDENTS.add(new Student(lastId+1, student.getName()));
        return STUDENTS.get(STUDENTS.size()-1);
    }

    @PutMapping("{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId,
                                 @RequestBody Student student){
        System.out.println("updateStudent");
    }
}
