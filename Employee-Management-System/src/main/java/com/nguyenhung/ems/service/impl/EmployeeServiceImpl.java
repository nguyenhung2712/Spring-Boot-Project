package com.nguyenhung.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nguyenhung.ems.entity.Employee;
import com.nguyenhung.ems.repository.EmployeeRepository;
import com.nguyenhung.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepo.findAll();
	}
	@Override
	public Employee saveEmployee(Employee employee) {
		return this.employeeRepo.save(employee);
	}
	@Override
	public Employee getEmployeeById(Long id) {
		return this.employeeRepo.findById(id).get();
	}
	@Override
	public void removeEmployeeById(Long id) {
		this.employeeRepo.deleteById(id);
		
	}
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			  Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepo.findAll(pageable);
	}
	
}
