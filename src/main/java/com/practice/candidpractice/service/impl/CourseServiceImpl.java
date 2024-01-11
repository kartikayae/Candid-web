package com.practice.candidpractice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.practice.candidpractice.dao.CourseRepository;
import com.practice.candidpractice.entities.Course;
import com.practice.candidpractice.service.CourseService;

public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course getCourse(String id) {
        return courseRepository.findById(id).get();
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) throws Exception {
        courseRepository.deleteById(id);
    }
}
