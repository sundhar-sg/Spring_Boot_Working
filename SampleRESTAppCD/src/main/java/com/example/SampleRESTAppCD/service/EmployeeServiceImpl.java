package com.example.SampleRESTAppCD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SampleRESTAppCD.dao.EmployeeDAO;
import com.example.SampleRESTAppCD.entity.Employee;
import com.example.SampleRESTAppCD.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepo) {
		this.employeeRepo = theEmployeeRepo;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return this.employeeRepo.findAll();
	}

	@Override
	public Employee findByID(int id) {
		// TODO Auto-generated method stub
		return this.employeeRepo.findById(id).get();
	}

	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return this.employeeRepo.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		this.employeeRepo.deleteById(id);
	}
}