package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Employee;

public interface EmployeeService {

	Employee findById(long id);

	Employee findByName(String name);

	void saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployeeById(long id);

	List<Employee> findAllEmployees();

	boolean isEmployeeExist(Employee employee);
}
