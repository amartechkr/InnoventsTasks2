package com.example.demo.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/*Employee Class that contains Employee Data
*/

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	/* The id is Auto-generated */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private Long employee_id;

	/* name of the Employee */
	@Column(name = "NAME", length = 3)
	private String name;

	/* The dateOfBirth */
	@Column(name = "DATE_OF_BIRTH")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth;

	/* The many-to-many relationship for both the tables */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "employee_address", joinColumns = @JoinColumn(name="employee_id", referencedColumnName ="id"),
			inverseJoinColumns  = @JoinColumn(name = "address_id", referencedColumnName = "id"))
	private Set<Address> address;

	/**
	 * 
	 */
	public Employee() {
	}
	
	/**
	 * @param name
	 * @param dateOfBirth
	 */
	public Employee(String name, LocalDate dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}


	/**
	 * @return the employee_id
	 */
	public Long getEmployee_id() {
		return employee_id;
	}

	/**
	 * @param employee_id the employee_id to set
	 */
	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the address
	 */
	public Set<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	
	
}

