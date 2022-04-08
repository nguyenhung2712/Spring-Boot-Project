package com.nguyenhung.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenhung.sms.entity.Student;
import com.nguyenhung.sms.repository.StudentRepository;
import com.nguyenhung.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public StudentServiceImpl(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public List<Student> getAllStudents() {
		return this.studentRepo.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		return this.studentRepo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return this.studentRepo.findById(id).get();
	}

	@Override
	public Student editStudent(Student student) {
		return this.studentRepo.save(student);
	}

	@Override
	public void removeStudentById(Long id) {
		this.studentRepo.deleteById(id);
		
	}
	
}