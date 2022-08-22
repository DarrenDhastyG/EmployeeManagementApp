package com.employeeManagement.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String id;
	
//	@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	@Column(unique=true)
	private String login;
	
	private String name;
	private double salary; 

	public Employee() {
		
	}
	
	public Employee (String id, String login, String name, double salary)
	{
		//super();
		this.id = id;
		this.login = login;
		this.name = name;
		this.salary = salary;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	/* 
	 * id - unique alphanumeric ID assigned by the company.
		● login - unique alphanumeric login assigned by the company.
		● name - possibly non-unique name. May not be in English, so please use UTF-8
		encoding.
		● salary - decimal that is >= 0.00.
	 *  
	 * 
	 * 
	 * 
	 * */
}
