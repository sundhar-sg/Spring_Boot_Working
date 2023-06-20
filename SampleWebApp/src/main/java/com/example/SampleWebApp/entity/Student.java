package com.example.SampleWebApp.entity;

public class Student {
	
	private String studentID;
	private String firstName;
	private String lastName;
	
	public Student(String studentID, String firstName, String lastName) {
		super();
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getStudentID() {
		return studentID;
	}
	
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}