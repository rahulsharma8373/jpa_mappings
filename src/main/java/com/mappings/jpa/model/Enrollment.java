package com.mappings.jpa.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Enrollment {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String grade;

	    @ManyToOne
	    @JoinColumn(name = "student_id")
	    private Student student;

	    @ManyToMany(mappedBy = "enrollments")
	    private List<Course> courses;
	}