package com.springboot.employeemang.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class SalaryDTO {

	@NotNull
	private int salary_id;
	
	@NotNull
	private int employeeID;
	
	@NotNull
	private double amount;
	
	@NotNull
	@NotEmpty
	private String payroll;

	public SalaryDTO(@NotNull int employeeID, @NotNull double amount, @NotNull @NotEmpty String payroll) {
		super();
		this.employeeID = employeeID;
		this.amount = amount;
		this.payroll = payroll;
	}

	public SalaryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSalary_id() {
		return salary_id;
	}

	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPayroll() {
		return payroll;
	}

	public void setPayroll(String payroll) {
		this.payroll = payroll;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "SalaryDTO [salary_id=" + salary_id + ", employeeID=" + employeeID + ", amount=" + amount + ", payroll="
				+ payroll + "]";
	}
}