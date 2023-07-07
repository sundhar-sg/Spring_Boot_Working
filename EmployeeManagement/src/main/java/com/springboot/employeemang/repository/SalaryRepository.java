package com.springboot.employeemang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.employeemang.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {

}