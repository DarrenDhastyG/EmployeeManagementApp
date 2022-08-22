package com.employeeManagement.springboot.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employeeManagement.springboot.exception.ApiException;
import com.employeeManagement.springboot.exception.ErrorResponse;
import com.employeeManagement.springboot.model.Employee;
import com.employeeManagement.springboot.model.csvHelper;
import com.employeeManagement.springboot.repository.EmployeeRepository;
import com.employeeManagement.springboot.service.CSVService;
import com.employeeManagement.springboot.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class EmployeeController {

	private EmployeeService employeeService;
	
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
	@Autowired
	CSVService fileService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employee")
	public List<Employee> getEmployees() {
		return this.employeeRepository.findAll();
	}
	
	public static final String DIRECTORY = System.getProperty("user.home") + "/Pictures/";
	
	@PostMapping("/upload")
	public ResponseEntity<List<String>> uploadFiles(@RequestParam("files")List<MultipartFile> multipartFiles) throws IOException{
		String message = "";
		List<String> filenames = new ArrayList<>();
		for(MultipartFile file : multipartFiles) {
			String filename = StringUtils.cleanPath(file.getOriginalFilename());
//			Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
//			copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
			filenames.add(filename);
			
			if (csvHelper.hasCSVFormat(file))
			{
				try {
					fileService.save(file);
				}
				 catch (Exception e) {
				        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				        System.out.println(message + e);
				        //return (ResponseEntity<List<String>>) ResponseEntity.status(HttpStatus.EXPECTATION_FAILED);
				}
			}
		}
	
		return ResponseEntity.ok().body(filenames);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() throws Exception {
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) throws Exception {
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PostMapping("/employee/add")
	public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee) throws Exception {
		try {
			Employee newEmployee = employeeService.addEmployee(employee);
			return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
		}
		
		catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	@PutMapping("/employee/update")
	public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee) throws Exception {
		Employee updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id) throws Exception {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleAllOtherErrors(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResponse(exception.getMessage()));
    }
}
