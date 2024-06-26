package com.mappings.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.jpa.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}