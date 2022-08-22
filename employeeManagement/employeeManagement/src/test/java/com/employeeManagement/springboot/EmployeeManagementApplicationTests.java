package com.employeeManagement.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.HttpURLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.employeeManagement.springboot.controller.EmployeeController;
import com.employeeManagement.springboot.model.Employee;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
class EmployeeManagementApplicationTests {

		 @Autowired
	   private MockMvc mvc;

	   @InjectMocks
	   private EmployeeController employeeController;
/*
	   @Test
	    public void testAddEmployee() 
	    {
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	        //ResponseEntity<Employee> employees = new Employee();
	        when(employeeController.addEmployee(any(Employee.class))).thenReturn(true);
	         
	        Employee employee = new Employee("121jkhsad", "Lokesh", "Gupta", 27364);
	        ResponseEntity<Employee> responseEntity = employeeController.addEmployee(employee);
	         
	        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
	    }
	     */
	   
	   
	   /*
	   @Test
	    void ensureThatUserAPICallReturnStatusCode200() throws Exception {
	        HttpClient client = HttpClient.newBuilder().build();
	        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:4200/api/employee")).build();
	        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	        assertThat(response.statusCode()).isEqualTo(200);
	    }
	   
	    @Test
	    void ensureThatJsonIsReturnedAsContentType() throws Exception {
	        HttpClient client = HttpClient.newBuilder().build();
	        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:4200/api/employee")).build();
	        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	        Optional<String> firstValue = response.headers().firstValue("Content-Type");
	        String string = firstValue.get();
	        assertThat(string).startsWith("application/json");
	    } 
*/
	    
	    
	    /*
		@Test
		void ensurePOSTBody() throws Exception {
		       HttpClient client = HttpClient.newBuilder().build();
		        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:4200/api/employee")).build();
		        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		        assertThat(response.statusCode()).isEqualTo(200);
		        Employee myModel = response.readEntity(Employee.class);
		        assertEquals(42, myModel.getResult());
		    }
			   
	   @Test
	   public void getEmployees() throws Exception {
	       Employee employee = new Employee("abc123","TesterABC","Tester",7500);
	       Employee employeeTwo = new Employee("defg123", "TesterDEF", "TestTwo", 8000);
	       
	       List<Employee> allEmployees = new ArrayList<>();
	       allEmployees.add(employeeTwo);
	       
	       Mockito.when(employeeController.addEmployee(Mockito.any),
					Mockito.any(Course.class))).thenReturn(mockCourse);

					
	       // Send course as body to /students/Student1/courses
	       	RequestBuilder requestBuilder = MockMvcRequestBuilders
			.post("/students/Student1/courses")
			.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
			.contentType(MediaType.APPLICATION_JSON);

	       
	       assertEquals(employeeController.getAllEmployees(), allEmployees);
	       given(employeeController.getAllEmployees()).(allEmployees);

	       mvc.perform(get(//(VERSION + ARRIVAL + "all")
	               //.with(user("blaze").password("Q1w2e3r4"))
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk())
	               .andExpect(jsonPath("$", hasSize(1)))
	               .andExpect(jsonPath("$[0].city", is(arrival.getCity())));
	   }

	   @Test
	   public void getEmployeesById() throws Exception {
		   Employee employee = new Employee("abc4123","TesterABC","Tester2",7500);

	       given(employeeController.getEmployeeById(employee.getId())).willReturn(employee);

	       mvc.perform(get(VERSION + ARRIVAL + arrival.getId())
	               .with(user("blaze").password("Q1w2e3r4"))
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk())
	               .andExpect(jsonPath("city", is(arrival.getCity())));
	   } 
	} */
}
