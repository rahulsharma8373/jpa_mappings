package com.mappings.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mappings.jpa.model.Student;
import com.mappings.jpa.repository.AddressRepository;
import com.mappings.jpa.repository.CourseRepository;
import com.mappings.jpa.repository.EnrollmentRepository;
import com.mappings.jpa.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        if (student.getAddress() != null) {
            addressRepository.save(student.getAddress());
        }
        if (student.getEnrollments() != null) {
            student.getEnrollments().forEach(enrollment -> {
                if (enrollment.getCourses() != null) {
                    enrollment.getCourses().forEach(course -> courseRepository.save(course));
                }
                enrollmentRepository.save(enrollment);
            });
        }
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(studentDetails.getName());
            student.setAddress(studentDetails.getAddress());
            student.setEnrollments(studentDetails.getEnrollments());
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
