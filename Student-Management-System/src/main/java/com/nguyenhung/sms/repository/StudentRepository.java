package com.nguyenhung.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenhung.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
} 
