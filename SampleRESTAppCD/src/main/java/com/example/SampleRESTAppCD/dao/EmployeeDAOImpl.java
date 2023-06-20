package com.example.SampleRESTAppCD.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.SampleRESTAppCD.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		List<Employee> result = theQuery.getResultList();
		return result;
	}

	@Override
	public Employee findByID(int id) {
		// TODO Auto-generated method stub
		Employee theEmployee = entityManager.find(Employee.class, id);
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		Employee dbEmployee = entityManager.merge(theEmployee);
		return dbEmployee;
	}

	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		Employee theEmployee = entityManager.find(Employee.class, id);
		entityManager.remove(theEmployee);
	}
}