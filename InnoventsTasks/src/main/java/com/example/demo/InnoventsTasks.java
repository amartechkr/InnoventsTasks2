package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.dao.AddressRepository;
import com.example.demo.dao.EmployeeRepository;

@SpringBootApplication
public class InnoventsTasks implements CommandLineRunner {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(InnoventsTasks.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Cleanup the tables
		
		employeeRepository.deleteAllInBatch();
		addressRepository.deleteAllInBatch();
		
	}

}
