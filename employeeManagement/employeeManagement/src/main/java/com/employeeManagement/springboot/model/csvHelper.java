package com.employeeManagement.springboot.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;
import com.employeeManagement.springboot.model.Employee;

public class csvHelper {
	  public static String TYPE = "text/csv";
	  static String[] HEADERs = { "id", "login", "name", "salary" };
	  public static boolean hasCSVFormat(MultipartFile file){
	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }
	    return true;
	  }
	  public static List<Employee> csvToEmployees(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
	      List<Employee> employees = new ArrayList<Employee>();
	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
	      for (CSVRecord csvRecord : csvRecords) {
	    	  if (!csvRecord.get(0).equals("#")) //if line is not a comment
	    	  {
		    	  Employee employee = new Employee(
			              csvRecord.get("id"),
			              csvRecord.get("login"),
			              csvRecord.get("name"),
			              Double.parseDouble(csvRecord.get("salary"))
			            );
			        employees.add(employee);
	    	  }
	      }
	      return employees;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }
}
