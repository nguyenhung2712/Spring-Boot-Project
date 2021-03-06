package com.nguyenhung.ems.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nguyenhung.ems.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	void removeEmployeeById(Long id);
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
