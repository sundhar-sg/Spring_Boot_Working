package com.springboot.employeemang.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EmployeeDTO {

	@NotNull
	private int emp_id;
	
	@NotNull
	@NotEmpty
	private String firstName;
	
	@NotNull
	@NotEmpty
	private String lastName;
	
	@NotNull
	private SalaryDTO salary;
	
	@NotNull
	private DepartmentDTO department;
	
	@NotNull
	@NotEmpty
	private String gender;
	
	@NotNull
	@NotEmpty
	private String email;

	public EmployeeDTO(@NotNull int emp_id, @NotNull @NotEmpty String firstName, @NotNull @NotEmpty String lastName,
			@NotNull SalaryDTO salary, @NotNull DepartmentDTO department, @NotNull @NotEmpty String gender,
			@NotNull @NotEmpty String email) {
		super();
		this.emp_id = emp_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.department = department;
		this.gender = gender;
		this.email = email;
	}

	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
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

	public SalaryDTO getSalary() {
		return salary;
	}

	public void setSalary(SalaryDTO salary) {
		this.salary = salary;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}