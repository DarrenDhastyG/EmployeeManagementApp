package com.employeeManagement.springboot.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagement.springboot.exception.ApiException;
import com.employeeManagement.springboot.exception.UserNotFoundException;
import com.employeeManagement.springboot.model.Employee;
import com.employeeManagement.springboot.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee addEmployee(Employee employee) throws ApiException {
		try {
		employee.setId(UUID.randomUUID().toString().substring(0, 6));
		return employeeRepository.save(employee);
		}
		catch (Exception e) {
			throw new ApiException(e.getMessage());
		}
	}
	
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee findEmployeeById(String id) {
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(()-> new UserNotFoundException ("ID" + id + "not found"));
	}
	
	@Transactional
	public void deleteEmployee(String id) {
		employeeRepository.deleteEmployeeById(id);
	}
}
