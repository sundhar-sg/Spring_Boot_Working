package com.example.SampleWebApp.restapi;

import java.util.ArrayList;
import java.util.List;
import com.example.SampleWebApp.restapi.entity.Student;
import com.example.SampleWebApp.restapi.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest-api")
public class DemoRestController {

	List<Student> students = new ArrayList<Student>();

	@PostConstruct
	public void loadData() {
		students.add(new Student(1, "Sundhar", "S G"));
		students.add(new Student(2, "Kishore", "K"));
		students.add(new Student(3, "Siddharrth", "G M"));
		students.add(new Student(4, "Gokul", "A P"));
		students.add(new Student(5, "Partha", "M K"));
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World from Spring REST API";
	}

	@GetMapping("/students-list")
	public List<Student> getStudentList() {
		return students;
	}

	@GetMapping("/students/{studentID}")
	public Student getStudent(@PathVariable int studentID) {
		if ((studentID > students.size()) || studentID < 0)
			throw new StudentNotFoundException("Student ID not Found - " + studentID);
		return students.get(studentID);
	}
}