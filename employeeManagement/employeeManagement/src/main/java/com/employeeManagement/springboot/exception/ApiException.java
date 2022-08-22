package com.employeeManagement.springboot.exception;

public class ApiException extends Exception{

	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	public String getErrorMessage() {
		return errorMessage;
	}
	public ApiException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public ApiException() {
		super();
	}
}
