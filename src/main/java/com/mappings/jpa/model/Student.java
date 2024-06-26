package com.mappings.jpa.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	    private String name;
	    @OneToOne
	    @JoinColumn(name = "address_id")
	    private Address address;
	    @OneToMany(mappedBy = "student")
	    private List<Enrollment> enrollments;
}
