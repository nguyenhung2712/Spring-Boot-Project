package com.nguyenhung.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenhung.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
