package com.mappings.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.jpa.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
