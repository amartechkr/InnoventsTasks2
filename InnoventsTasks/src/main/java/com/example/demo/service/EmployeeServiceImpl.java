package com.example.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<Employee> employees;
	
	@Override
	public Employee findById(long id) {
		for(Employee employee : employees){
			if(employee.getEmployee_id() == id){
				return employee;
			}
		}
		return null;
	}

	@Override
	public Employee findByName(String name) {
		for(Employee employee : employees){
			if(employee.getName().equalsIgnoreCase(name)){
				return employee;
			}
		}
		return null;
	}

	@Override
	public void saveEmployee(Employee employee) {
		employee.setEmployee_id(counter.incrementAndGet());
		employees.add(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		int index = employees.indexOf(employee);
		employees.set(index, employee);
		
	}

	@Override
	public void deleteEmployeeById(long id) {
		for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
			Employee employee = iterator.next();
		    if (employee.getEmployee_id() == id) {
		        iterator.remove();
		    }
		}
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employees;
	}

	@Override
	public boolean isEmployeeExist(Employee employee) {
		return findByName(employee.getName())!=null;
	}

	

}
