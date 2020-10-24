package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceImpl;
import com.example.demo.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeServiceImpl employeeServiceImpl; // Service which will do all data retrieval/manipulation work

	// -------------------Retrieve Employee based on Name------------------------------------------
	
	@RequestMapping(value = "/employee/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployeeByName(@PathVariable("name") String name) {
		logger.info("Fetching Employee with name {}", name);
		Employee employee = employeeServiceImpl.findByName(name);
		if (employee == null) {
			logger.error("Employee with id {} not found.", name);
			return new ResponseEntity(new CustomErrorType("Employee with name " + name 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	// -------------------Perform  Partial Update on Address  -------------------
	
	@RequestMapping(value = "/address/{address_id}", method = RequestMethod.PATCH)
	public ResponseEntity<?> updatePartially(@RequestBody String city, @PathVariable("address_id") long address_id){
		logger.info("partial Update on  Adress with  {}", city,"and"+ address_id);
		
		
		
		return null;
	}
	
// -------------------Create a Employee-------------------------------------------

	@RequestMapping(value = "/employee/", method = RequestMethod.POST)
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Employee : {}", employee);
		if (employeeServiceImpl.isEmployeeExist(employee)) {
			logger.error("Unable to create. A Employee with name {} already exist", employee.getName());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A Employee with name " + employee.getName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		employeeServiceImpl.saveEmployee(employee);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/employee/{id}").buildAndExpand(employee.getEmployee_id()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
// ------------------- Update a Employee ------------------------------------------------
	 
    @RequestMapping(value = "/employee/{employee_id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(@PathVariable("employee_id") long employee_id, @RequestBody Employee employee) {
        logger.info("Updating Employee with id {}", employee_id);
 
        Employee currentEmployee = employeeServiceImpl.findById(employee_id);
 
        if (currentEmployee == null) {
            logger.error("Unable to update. Employee with id {} not found.", employee_id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Employee with id " + employee_id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentEmployee.setName(currentEmployee.getName());
        currentEmployee.setDateOfBirth(currentEmployee.getDateOfBirth());
 
        employeeServiceImpl.updateEmployee(currentEmployee);
        return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
    }
 
// ------------------- Delete a Employee-----------------------------------------

 	@RequestMapping(value = "/employee/{employee_id}", method = RequestMethod.DELETE)
 	public ResponseEntity<?> deleteEmployee(@PathVariable("employee_id") long employee_id) {
 		logger.info("Fetching & Deleting Employee with id {}", employee_id);

 		Employee employee = employeeServiceImpl.findById(employee_id);
 		if (employee == null) {
 			logger.error("Unable to delete. Employee with id {} not found.", employee_id);
 			return new ResponseEntity(new CustomErrorType("Unable to delete. Employee with id " + employee_id + " not found."),
 					HttpStatus.NOT_FOUND);
 		}
 		employeeServiceImpl.deleteEmployeeById(employee_id);
 		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
 	}
 	

// -------------------Retrieve All Employees---------------------------------------------
 	
	@RequestMapping(value = "/employee/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAllEmployees() {
		List<Employee> employees = employeeServiceImpl.findAllEmployees();
		if (employees.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

// -------------------Retrieve Single Employee------------------------------------------

	@RequestMapping(value = "/employee/{employee_id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployee(@PathVariable("employee_id") long employee_id) {
		logger.info("Fetching Employee with id {}", employee_id);
		Employee employee = employeeServiceImpl.findById(employee_id);
		if (employee == null) {
			logger.error("Employee with id {} not found.", employee_id);
			return new ResponseEntity(new CustomErrorType("Employee with id " + employee_id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
}
