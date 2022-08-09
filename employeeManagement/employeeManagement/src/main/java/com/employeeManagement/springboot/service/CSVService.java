package com.employeeManagement.springboot.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employeeManagement.springboot.model.Employee;
import com.employeeManagement.springboot.repository.EmployeeRepository;
import com.employeeManagement.springboot.model.csvHelper;

@Service
public class CSVService {
  @Autowired
  EmployeeRepository repository;
  public void save(MultipartFile file) {
    try {
      List<Employee> employees = csvHelper.csvToEmployees(file.getInputStream());
      repository.saveAll(employees);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }
  public List<Employee> getAllEmployees() {
    return repository.findAll();
  }
}