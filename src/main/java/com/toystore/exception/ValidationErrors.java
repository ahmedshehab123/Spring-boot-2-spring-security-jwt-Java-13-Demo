package com.toystore.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ValidationErrors {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy : hh:mm:ss")
	private Date timestamp;
	private String message;
	private List<String> details;
	public ValidationErrors() {
		this.timestamp = new Date();
		this.details = new ArrayList<>();
	}
	public void addError(String details) {
		this.details.add(details);
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails() {
		return details;
	}

	
	
	

}
