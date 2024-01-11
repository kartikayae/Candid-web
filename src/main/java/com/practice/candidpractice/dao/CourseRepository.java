package com.practice.candidpractice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.candidpractice.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

}
