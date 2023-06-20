package com.example.SampleWebApp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SampleWebApp.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("rest-api")
public class StudentRESTController {

	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("18ISR053", "Sundhar", "S G"));
		theStudents.add(new Student("18ISR025", "Kishore", "K"));
		theStudents.add(new Student("18ISR047", "Siddharrth", "G M"));
		theStudents.add(new Student("18ISR050", "Gokul", "A P"));
		theStudents.add(new Student("18ISR033", "Partha", "M K"));
	}
	
	@GetMapping("/students/{studentID}")
	public Student getStudentsList(@PathVariable String studentID) {
		Student filterStudent = null;
		for(Student student : theStudents) {
			if(student.getStudentID().equals(studentID)) {
				filterStudent = student;
			}
		}
		return filterStudent;
	}
}