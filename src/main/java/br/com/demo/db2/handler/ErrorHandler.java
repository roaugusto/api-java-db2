package br.com.demo.db2.handler;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ErrorHandler {

	@JsonProperty(value = "Errors")
	private ErrorResponse errorResponse;
	
	
	public ErrorHandler(int statusCode, String message) {
	
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(String.valueOf(statusCode));
		errorResponse.setMessage(message);
		
		this.errorResponse = errorResponse;
		
	}
	
}
