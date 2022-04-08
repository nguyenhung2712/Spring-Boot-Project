package com.nguyenhung.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyenhung.ems.entity.Employee;
import com.nguyenhung.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping(value = {"/index", "/"})
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);
	}
	@GetMapping("/index/add-employee")
	public String addEmployeeForm(Model model) {
		Employee e = new Employee();
		model.addAttribute("employee", e);
		return "add-employee";
	}
	@PostMapping("/index")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		this.employeeService.saveEmployee(employee);
		return "redirect:/index";
	}
	
	@GetMapping("/index/edit-employee/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", this.employeeService.getEmployeeById(id));
		return "edit-employee";
	}
	
	@PostMapping("/index/{id}")
	public String editEmployee(
			@PathVariable Long id, @ModelAttribute("employee") Employee employee,
			Model model) {
		Employee selectedEmployee = this.employeeService.getEmployeeById(id);
		selectedEmployee.setId(id);
		selectedEmployee.setFirstName(employee.getFirstName());
		selectedEmployee.setLastName(employee.getLastName());
		selectedEmployee.setEmail(employee.getEmail());
		
		this.employeeService.saveEmployee(employee);
		
		return "redirect:/index";
	}
	
	@GetMapping("/index/{id}")
	public String removeEmployee(@PathVariable Long id) {
		this.employeeService.removeEmployeeById(id);
		return "redirect:/index";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(
			@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		Page<Employee> page = this.employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Employee> empsList = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	    
		model.addAttribute("employeesList", empsList);
		return "index";
	}
}
