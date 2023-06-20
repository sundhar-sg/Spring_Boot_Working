package com.example.SampleRESTAppCD.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.SampleRESTAppCD.entity.Employee;
import com.example.SampleRESTAppCD.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRESTController(EmployeeService theEmployeeService) {
		this.employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeID}")
	public Employee findByID(@PathVariable("employeeID") int id) {
		Employee theEmployee =  employeeService.findByID(id);
		if(theEmployee == null)
			throw new RuntimeException("Employee ID not found - " +id);
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		return employeeService.save(theEmployee);
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee theEmployee) {
		return employeeService.save(theEmployee);
	}
	
	@DeleteMapping("/employees/{employeeID}")
	public String deleteEmp(@PathVariable("employeeID") int id) {
		Employee theEmployee = employeeService.findByID(id);
		if(theEmployee == null)
			throw new RuntimeException("No Employee found for ID: " +id);
		employeeService.deleteByID(id);
		return "Deleted Employee ID: " +id;
	}
}