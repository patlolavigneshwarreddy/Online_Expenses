package com.example.expenses_server.dto;

public class ResponseErrorDto {
	int statuscode;
	String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	
	public ResponseErrorDto(String message, int statuscode) {
		super();
		this.message = message;
		this.statuscode = statuscode;
	}
	
}
