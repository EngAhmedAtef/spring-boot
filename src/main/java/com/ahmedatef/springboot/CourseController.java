package com.ahmedatef.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return Arrays.asList(
                new Course(1, "CSEN 101"),
                new Course(2, "CSEN 102"),
                new Course(3, "Database I"),
                new Course(4, "Database II"),
                new Course(5, "Circuits I"),
                new Course(6, "Circuits II"),
                new Course(7, "Drawing")
        );
    }

    @GetMapping("/")
    public String getHomePage() {
        return "Welcome to the Home Page!";
    }
}
