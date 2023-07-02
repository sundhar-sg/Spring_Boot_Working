package com.springboot.hibernate.onetoone.dao;

import java.util.List;

import com.springboot.hibernate.onetoone.entity.Course;
import com.springboot.hibernate.onetoone.entity.Instructor;
import com.springboot.hibernate.onetoone.entity.InstructorDetail;
import com.springboot.hibernate.onetoone.entity.Student;

public interface AppDAO {

	void save(Instructor theInstructor);
	
	Instructor findInstanceById(int theID);
	
	void deleteInstructorById(int theID);
	
	InstructorDetail findInstructorDetailById(int theID);
	
	void deleteInstructorDetailByID(int theID);
	
	List<Course> findCoursesByInstructorID(int theID);
	
	Instructor findInstructorByIDJoinFetch(int theID);
	
	void updateInstructor(Instructor theInstructor);
	
	void updateCourse(Course theCourse);
	
	Course findCourseByID(int theID);
	
	void deleteInstructor(int theID);
	
	void deleteCourse(int theID);
	
	void saveCourse(Course theCourse);
	
	Course findCourseAndReviewsByCourseID(int theID);
	
	Course findCourseAndStudentsByCourseID(int theID);
	
	Student findStudentWithCoursesByStudentID(int theID);
	
	void updateStudent(Student theStudent);
	
	void deleteStudentByID(int theID);
}