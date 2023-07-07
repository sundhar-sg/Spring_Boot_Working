package com.springboot.employeemang.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salary")
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salary_id")
	private int salary_id;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "payroll")
	private String payroll;
	
	@OneToOne(mappedBy = "salary", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Employee employee;

	public int getSalary_id() {
		return salary_id;
	}

	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPayroll() {
		return payroll;
	}

	public void setPayroll(String payroll) {
		this.payroll = payroll;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Salary(Double amount, String payroll) {
		super();
		this.amount = amount;
		this.payroll = payroll;
	}

	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Salary [salary_id=" + salary_id + ", amount=" + amount + ", payroll=" + payroll + "]";
	}
}