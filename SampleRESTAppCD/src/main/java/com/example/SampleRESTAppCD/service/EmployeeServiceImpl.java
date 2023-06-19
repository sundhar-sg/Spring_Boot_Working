package com.example.SampleRESTAppCD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SampleRESTAppCD.dao.EmployeeDAO;
import com.example.SampleRESTAppCD.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		this.employeeDAO = theEmployeeDAO;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	public Employee findByID(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.findByID(id);
	}

	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDAO.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		employeeDAO.deleteByID(id);
	}
}