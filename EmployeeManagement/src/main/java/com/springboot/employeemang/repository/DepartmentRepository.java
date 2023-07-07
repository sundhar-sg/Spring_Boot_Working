package com.springboot.employeemang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.employeemang.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}