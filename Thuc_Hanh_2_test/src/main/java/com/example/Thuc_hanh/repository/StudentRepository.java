package com.example.Thuc_hanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Thuc_hanh.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
	public Student findStudentById(String id);
}
