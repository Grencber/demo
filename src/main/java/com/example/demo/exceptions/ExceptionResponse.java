package com.example.demo.exceptions;

import java.util.Date;

public class ExceptionResponse {
	
	private Date date;
	private String message;
	private String description;
	public Date getDate() {
		return date;
	}
	public ExceptionResponse(Date date, String description, String message) {
		super();
		this.date = date;
		this.description = description;
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDate(Date date) {
		this.date = date;
	}


	
}
