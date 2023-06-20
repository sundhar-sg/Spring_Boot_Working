package com.example.SampleRESTAppCD.dao;

import java.util.List;

import com.example.SampleRESTAppCD.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
	
	Employee findByID(int id);
	
	Employee save(Employee theEmployee);
	
	void deleteByID(int id);
}