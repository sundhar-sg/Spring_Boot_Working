package com.springboot.employeemang.service;

import java.util.List;

import com.springboot.employeemang.dto.AttendanceDTO;
import com.springboot.employeemang.dto.DepartmentDTO;
import com.springboot.employeemang.dto.EmployeeDTO;
import com.springboot.employeemang.dto.SalaryDTO;

public interface EmployeeManagementService {

	EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
	
	EmployeeDTO findEmployeeByID(int employeeID);
	
	List<EmployeeDTO> findAllEmployees();
	
	EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
	
	void deleteEmployee(int employeeID);
	
	DepartmentDTO addDepartment(DepartmentDTO departmentDTO);
	
	DepartmentDTO findDepartmentByID(int deptID);
	
	DepartmentDTO findDepartmentWithEmployees(int deptID);
	
	List<DepartmentDTO> findAllDepartments();
	
	DepartmentDTO updateDepartment(DepartmentDTO departmentDTO);
	
	void deleteDepartment(int deptID);
	
	AttendanceDTO addAttendance(AttendanceDTO attendanceDTO);
	
	AttendanceDTO findAttendanceByID(int attendanceID);
	
	List<AttendanceDTO> findAllAttendancesForEmployee(int employeeID);
	
	AttendanceDTO updateAttendance(AttendanceDTO attendanceDTO);
	
	void deleteAttendance(int attendanceID);
	
	SalaryDTO addSalary(SalaryDTO salaryDTO);
	
	SalaryDTO findSalaryByID(int salaryID);
	
	List<SalaryDTO> findAllSalaries();
	
	SalaryDTO updateSalary(SalaryDTO salaryDTO);
	
	void deleteSalary(int salaryID);
} 