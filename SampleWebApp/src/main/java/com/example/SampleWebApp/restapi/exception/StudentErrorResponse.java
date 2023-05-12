package com.example.SampleWebApp.restapi.exception;

public class StudentErrorResponse {

	private int id;
	private String message;
	private long timestamp;
	
	public StudentErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentErrorResponse(int id, String message, long timestamp) {
		super();
		this.id = id;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}