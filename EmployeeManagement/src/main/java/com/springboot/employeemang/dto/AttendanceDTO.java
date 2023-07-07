package com.springboot.employeemang.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AttendanceDTO {

	@NotNull
	private int attendance_id;
	
	@NotNull
	private int employeeID;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "IST")
	private Date currentDate;
	
	@NotNull
	@NotEmpty
	private String attendanceStatus;

	public AttendanceDTO(Date currentDate, @NotNull @NotEmpty String attendanceStatus, @NotNull int employeeID) {
		super();
		this.currentDate = currentDate;
		this.attendanceStatus = attendanceStatus;
		this.employeeID = employeeID;
	}

	public AttendanceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
}