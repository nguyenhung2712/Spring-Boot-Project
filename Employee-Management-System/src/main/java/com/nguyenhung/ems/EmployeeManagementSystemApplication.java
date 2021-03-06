package com.nguyenhung.ems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nguyenhung.ems.entity.Employee;
import com.nguyenhung.ems.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}
	@Autowired
	private EmployeeRepository employeeRepo;
	@Override
	public void run(String... args) throws Exception {
		/*Employee s1 = new Employee("Nguyễn", "Hưng", "nguyenhung12c1@gmail.com");
		Employee s2 = new Employee("Nguyễn", "Hùng", "sieupha2712@gmail.com");
		
		this.employeeRepo.save(s1);
		this.employeeRepo.save(s2);*/
	}

}
