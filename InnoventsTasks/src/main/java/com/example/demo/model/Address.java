package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*Address Class that contains Employee Data
*/

@Entity
@Table(name = "ADDRESS")
public class Address {

	/* The id is Auto-generated */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	private Long address_id;
	
	/* addrLineOne of the addressLineOne */
	@Column(name = "ADDRESS_LNE_ONE", length = 5)
	private String addrLineOne;
	
	/* addrLineOne of the addrLineTwo */
	@Column(name = "ADDRESS_LNE_TWO")
	private String addrLineTwo;
	
	/* city of the Address */
	@Column(name = "CITY")
	private String city;
	
	/*mapping  Address to the Employee  */
	@ManyToMany(mappedBy = "address", fetch = FetchType.EAGER)
	private Set<Employee> employees;

	/**
	 * 
	 */
	public Address() {
	}

	/**
	 * @param address_id
	 * @param addrLineOne
	 * @param addrLineTwo
	 * @param city
	 * @param employees
	 */
	public Address(Long address_id, String addrLineOne, String addrLineTwo, String city, Set<Employee> employees) {
		this.address_id = address_id;
		this.addrLineOne = addrLineOne;
		this.addrLineTwo = addrLineTwo;
		this.city = city;
		this.employees = employees;
	}

	/**
	 * @return the address_id
	 */
	public Long getAddress_id() {
		return address_id;
	}

	/**
	 * @param address_id the address_id to set
	 */
	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}

	/**
	 * @return the addrLineOne
	 */
	public String getAddrLineOne() {
		return addrLineOne;
	}

	/**
	 * @param addrLineOne the addrLineOne to set
	 */
	public void setAddrLineOne(String addrLineOne) {
		this.addrLineOne = addrLineOne;
	}

	/**
	 * @return the addrLineTwo
	 */
	public String getAddrLineTwo() {
		return addrLineTwo;
	}

	/**
	 * @param addrLineTwo the addrLineTwo to set
	 */
	public void setAddrLineTwo(String addrLineTwo) {
		this.addrLineTwo = addrLineTwo;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the employees
	 */
	public Set<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
