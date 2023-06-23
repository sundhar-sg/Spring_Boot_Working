package com.example.SampleRESTAppCD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SampleRESTAppCD.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}