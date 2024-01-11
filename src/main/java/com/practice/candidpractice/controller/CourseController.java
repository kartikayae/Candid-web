package com.practice.candidpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.candidpractice.entities.Course;
import com.practice.candidpractice.service.CourseService;

@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public void addCourse(Course course) {
        this.courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable(value = "id") String id) {

    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable(value = "id") String id) {
        try {
            this.courseService.deleteCourse(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/{id}")
    public void getCourse(@PathVariable(value = "id") String id) {
        this.courseService.getCourse(id);
    }

    @GetMapping
    public void getCourses() {
        this.courseService.getAllCourses();
    }
}
