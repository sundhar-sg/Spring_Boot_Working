package com.example.SampleRESTAppCD.service;

import java.util.List;

import com.example.SampleRESTAppCD.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findByID(int id);
	
	Employee save(Employee theEmployee);
	
	void deleteByID(int id);
}