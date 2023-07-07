package com.springboot.employeemang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.employeemang.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}