package com.nguyenhung.sms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.nguyenhung.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	//private StudentRepository studentRepo;
	@Override
	public void run(String... args) throws Exception {
		/*Student s1 = new Student("Nguyễn", "Hưng", "nguyenhung12c1@gmail.com");
		Student s2 = new Student("Nguyễn", "Hùng", "sieupha2712@gmail.com");
		
		this.studentRepo.save(s1);
		this.studentRepo.save(s2);*/
	}

}