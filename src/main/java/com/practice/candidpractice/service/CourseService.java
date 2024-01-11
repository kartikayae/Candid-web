package com.practice.candidpractice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.candidpractice.entities.Course;

@Service
public interface CourseService {
    public Course getCourse(String id);

    public List<Course> getAllCourses();

    public void addCourse(Course course);

    public void deleteCourse(String id) throws Exception;
}
