package com.mappings.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.jpa.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}