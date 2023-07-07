package com.springboot.employeemang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeemang.dto.AttendanceDTO;
import com.springboot.employeemang.dto.DepartmentDTO;
import com.springboot.employeemang.dto.EmployeeDTO;
import com.springboot.employeemang.dto.SalaryDTO;
import com.springboot.employeemang.service.EmployeeManagementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeManagementController {
	
	@Autowired
	private EmployeeManagementService emService;

	@PostMapping("/employees/add")
	public ResponseEntity<?> addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(emService.addEmployee(employeeDTO));
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> findEmployeeByID(@PathVariable("id") int employeeID) {
		return ResponseEntity.status(HttpStatus.FOUND).body(emService.findEmployeeByID(employeeID));
	}
	
	@GetMapping("/employees")
	public ResponseEntity<?> findAllEmployees() {
		return ResponseEntity.status(HttpStatus.FOUND).body(emService.findAllEmployees());
	}
	
	@PutMapping("/employees")
	public ResponseEntity<?> updateEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(emService.updateEmployee(employeeDTO));
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int employeeID) {
		emService.deleteEmployee(employeeID);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted the employee details");
	}
	
	@PostMapping("/attendance/add")
	public ResponseEntity<?> addAttendance(@RequestBody @Valid AttendanceDTO attendanceDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(emService.addAttendance(attendanceDTO));
	}
	
	@GetMapping("/attendance/{attendance_id}")
	public ResponseEntity<?> findAttendanceByID(@PathVariable("attendance_id") int attendance_id) {
		return ResponseEntity.status(HttpStatus.FOUND).body(emService.findAttendanceByID(attendance_id));
	}
	
	@GetMapping("/attendance/employee/{employee_id}")
	public ResponseEntity<?> findAttendanceForEmployee(@PathVariable("employee_id") int employee_id) {
		return ResponseEntity.status(HttpStatus.FOUND).body(emService.findAllAttendancesForEmployee(employee_id));
	}
	
	@PutMapping("/attendance")
	public ResponseEntity<?> updateAttendance(@RequestBody AttendanceDTO attendanceDTO) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(emService.updateAttendance(attendanceDTO));
	}
	
	@DeleteMapping("/attendance/{id}")
	public ResponseEntity<?> deleteAttendance(@PathVariable("id") int attendance_id) {
		emService.deleteAttendance(attendance_id);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted the attendance details");
	}
	
	@PostMapping("/department/add")
	public ResponseEntity<?> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(emService.addDepartment(departmentDTO));
	}
	
	@GetMapping("/department/{id}")
	public ResponseEntity<?> findDepartmentByID(@PathVariable("id") int dept_id) {
		return ResponseEntity.status(HttpStatus.FOUND).body(emService.findDepartmentWithEmployees(dept_id));
	}
	
	@GetMapping("/department")
	public ResponseEntity<?> findAllDepartments() {
		return ResponseEntity.status(HttpStatus.FOUND).body(emService.findAllDepartments());
	}
	
	@PutMapping("/department")
	public ResponseEntity<?> updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(emService.updateDepartment(departmentDTO));
	}
	
	@DeleteMapping("/department/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable("id") int deptID) {
		emService.deleteDepartment(deptID);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted the department");
	}
	
	@PostMapping("/salary/add")
	public ResponseEntity<?> addSalary(@RequestBody SalaryDTO salaryDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(emService.addSalary(salaryDTO));
	}
	
	@GetMapping("/salary/{id}")
	public ResponseEntity<?> findSalaryByID(@PathVariable("id") int salary_id) {
		return ResponseEntity.status(HttpStatus.FOUND).body(emService.findSalaryByID(salary_id));
	}
	
	@GetMapping("/salary")
	public ResponseEntity<?> findAllSalaries() {
		return ResponseEntity.status(HttpStatus.FOUND).body(emService.findAllSalaries());
	}
	
	@PutMapping("/salary")
	public ResponseEntity<?> updateSalary(@RequestBody SalaryDTO salaryDTO) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(emService.updateSalary(salaryDTO));
	}
	
	@DeleteMapping("/salary/{id}")
	public ResponseEntity<?> deleteSalary(@PathVariable("id") int salary_id) {
		emService.deleteSalary(salary_id);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted the Salary Details");
	}
}