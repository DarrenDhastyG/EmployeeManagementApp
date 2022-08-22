package com.employeeManagement.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeManagement.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
	void deleteEmployeeById(String id);

	Optional<Employee> findEmployeeById(String id);
}
