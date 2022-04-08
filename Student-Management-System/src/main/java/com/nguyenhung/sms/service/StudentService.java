package com.nguyenhung.sms.service;

import java.util.List;

import com.nguyenhung.sms.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student addStudent(Student student);
	Student getStudentById(Long id);
	Student editStudent(Student student);
	void removeStudentById(Long id);
}
