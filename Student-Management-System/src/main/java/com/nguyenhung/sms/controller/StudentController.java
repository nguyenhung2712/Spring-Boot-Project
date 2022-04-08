package com.nguyenhung.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nguyenhung.sms.entity.Student;
import com.nguyenhung.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", this.studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/add-student")
	public String addStudentForm(Model model) {
		Student s = new Student();
		model.addAttribute("student", s);
		return "add-student";
	}
	
	@PostMapping("/students")
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.addStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", this.studentService.getStudentById(id));
		return "edit-student";
	}
	
	@PostMapping("/students/{id}")
	public String editStudent(
			@PathVariable Long id, @ModelAttribute("student") Student student,
			Model model) {
		Student selectedStudent = this.studentService.getStudentById(id);
		selectedStudent.setId(id);
		selectedStudent.setFirstName(student.getFirstName());
		selectedStudent.setLastName(student.getLastName());
		selectedStudent.setEmail(student.getEmail());
		
		this.studentService.editStudent(selectedStudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String removeStudent(@PathVariable Long id) {
		this.studentService.removeStudentById(id);
		return "redirect:/students";
	}
}
