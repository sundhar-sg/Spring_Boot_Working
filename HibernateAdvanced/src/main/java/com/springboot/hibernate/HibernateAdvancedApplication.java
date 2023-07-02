package com.springboot.hibernate;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.hibernate.onetoone.dao.AppDAO;
import com.springboot.hibernate.onetoone.entity.Course;
import com.springboot.hibernate.onetoone.entity.Instructor;
import com.springboot.hibernate.onetoone.entity.InstructorDetail;
import com.springboot.hibernate.onetoone.entity.Review;
import com.springboot.hibernate.onetoone.entity.Student;

@SpringBootApplication
public class HibernateAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAdvancedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			
			// createInstructor(appDAO);
			
			// findInstructor(appDAO);
			
			// deleteInstructor(appDAO);
			
			// findInstructorDetail(appDAO);
			
			// deleteInstructorDetail(appDAO);
			
			// createInstructorWithCourses(appDAO);
			
			// findInstructorWithCourses(appDAO);
			
			// findCoursesForInstructor(appDAO);
			
			// findCoursesForInstructorJoinFetch(appDAO);
			
			// updateInstructor(appDAO);
			
			// updateCourse(appDAO);
			
			// deleteInstructorWithCourses(appDAO);
			
			// deleteCourse(appDAO);
			
			// saveCourseWithReviews(appDAO);
			
			// findCourseWithReviews(appDAO);
			
			// deleteCourseWithReviews(appDAO);
			
			// createCourseWithStudents(appDAO);
			
			// findCourseWithStudents(appDAO);
			
			// findStudentWithCourses(appDAO);
			
			// updateStudentWithAddingNewCourses(appDAO);
			
			deleteStudent(appDAO);
			
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 2;
		System.out.println("Deleting the Student with ID: " +theID);
		appDAO.deleteStudentByID(theID);
		System.out.println("Done!!!");
	}

	private void updateStudentWithAddingNewCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 1;
		Student tempStudent = appDAO.findStudentWithCoursesByStudentID(theID);
		Course tempCourse1 = new Course("Spring Boot Masterclass with Chad Darby");
		Course tempCourse2 = new Course("Master the Data Structures and Algorithms");
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		System.out.println("Updating existing Student: " +tempStudent);
		System.out.println("Added New Courses: " +tempStudent.getCourses());
		appDAO.updateStudent(tempStudent);
		System.out.println("Done!!!");
	}

	private void findStudentWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 1;
		Student tempStudent = appDAO.findStudentWithCoursesByStudentID(theID);
		System.out.println("Retrieved Student Details: " +tempStudent);
		System.out.println("Their enrolled courses: " +tempStudent.getCourses());
		System.out.println("Done!!!");
	}

	private void findCourseWithStudents(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 6;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseID(theID);
		System.out.println("Retrieved Course: " +tempCourse);
		System.out.println("Enrolled Students: " +tempCourse.getStudents());
		System.out.println("Done!!!");
	}

	private void createCourseWithStudents(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Course tempCourse = new Course("Java Programming Masterclass");
		
		Student tempStudent1 = new Student("Sundhar", "S G", "sundhargopal462@outlook.com");
		Student tempStudent2 = new Student("Kishore", "K", "kishorekannan096@gmail.com");
		
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		
		System.out.println("Course Details: " +tempCourse);
		System.out.println("Enrolled Students: " +tempCourse.getStudents());
		
		appDAO.saveCourse(tempCourse);
		
		System.out.println("Done!!!");
	}

	private void deleteCourseWithReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 5;
		System.out.println("Deleting Course By ID: " +theID);
		appDAO.deleteCourse(theID);
		System.out.println("Done!!!");
	}

	private void findCourseWithReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 5;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseID(theID);
		System.out.println("Finding the Course by the ID: " +theID);
		System.out.println("Course Details: " +tempCourse);
		System.out.println("Their associated reviews: " +tempCourse.getReviews());
		System.out.println("Done!!!");
	}

	private void saveCourseWithReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Course tempCourse = new Course("Machine Learning for Beginners");
		tempCourse.addReview(new Review("Great Course from the author"));
		tempCourse.addReview(new Review("Worth every penny and totally worth it"));
		tempCourse.addReview(new Review("Totally money and time waste, Bad instructor"));
		System.out.println("Saving the Course");
		System.out.println("Course Details: " +tempCourse);
		System.out.println("Course Reviews: " +tempCourse.getReviews());
		appDAO.saveCourse(tempCourse);
		System.out.println("Done!!!");
	}

	private void deleteCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 7;
		System.out.println("Deleting the course by ID: " +theID);
		appDAO.deleteCourse(theID);
		System.out.println("Done!!!");
	}

	private void deleteInstructorWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 6;
		System.out.println("Deleting Instructor with the ID: " +theID);
		appDAO.deleteInstructor(theID);
	}

	private void updateCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 4;
		System.out.println("Finding Course By ID: " +theID);
		Course tempCourse = appDAO.findCourseByID(theID);
		System.out.println("Updating the Course By ID: " +theID);
		tempCourse.setTitle("Mastering GCP's Kubernetes services with me");
		appDAO.updateCourse(tempCourse);
		System.out.println("Done!!!");
	}

	private void updateInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 6;
		System.out.println("Finding Instructor By ID: " +theID);
		Instructor tempInstructor = appDAO.findInstanceById(theID);
		System.out.println("Updating Instructor ID: " +theID);
		tempInstructor.setLastName("Prabhu");
		appDAO.updateInstructor(tempInstructor);
		System.out.println("Done!!!");
	}

	private void findCoursesForInstructorJoinFetch(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 5;
		System.out.println("Finding Instructor with Courses based on ID: " +theID);
		Instructor tempInstructor = appDAO.findInstructorByIDJoinFetch(theID);
		System.out.println("Retrieved Instructor: " +tempInstructor);
		System.out.println("Finding courses for instructor ID: " +theID);
		System.out.println("Their associated courses: " +tempInstructor.getCourses());
		System.out.println("Done!!!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 5;
		System.out.println("Finding Instructor with Courses based on ID: " +theID);
		Instructor tempInstructor = appDAO.findInstanceById(theID);
		System.out.println("Retrieved Instructor: " +tempInstructor);
		System.out.println("Finding courses for instructor ID: " +theID);
		List<Course> retrievedCourses = appDAO.findCoursesByInstructorID(theID);
		tempInstructor.setCourses(retrievedCourses);
		System.out.println("Their associated courses: " +tempInstructor.getCourses());
		System.out.println("Done!!!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 5;
		System.out.println("Finding Instructor with Courses based on ID: " +theID);
		Instructor tempInstructor = appDAO.findInstanceById(theID);
		System.out.println("Retrieved Instructor: " +tempInstructor);
		System.out.println("Their associated courses: " +tempInstructor.getCourses());
		System.out.println("Done!!!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Instructor tempInstructor = new Instructor("Siddharrth", "G M", "siddhumahi01@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("https://www,youtube.com/siddharrth_gm/channel", "Full Stack Development");
		Instructor tempInstructor1 = new Instructor("Gokul", "A P", "gokulap07@gmail.com");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("https://www,youtube.com/gokul_ap/channel", "Cloud Development");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		
		Course tempCourse1 = new Course("Full Stack Development with PHP - The Ultimate Guide");
		Course tempCourse2 = new Course("Front - end Development with React");
		Course tempCourse3 = new Course("AWS Mastery with real world examples");
		Course tempCourse4 = new Course("Mastering Kubernetes with GCP services");
		
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor1.add(tempCourse3);
		tempInstructor1.add(tempCourse4);
		
		System.out.println("Saving Instructor: " +tempInstructor);
		System.out.println("Saving Instructor: " +tempInstructor1);
		
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);
		
		System.out.println("Done!!!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 3;
		System.out.println("Deleting Instructor Detail by ID: " +theID);
		appDAO.deleteInstructorDetailByID(theID);
		System.out.println("Done!!!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 1;
		System.out.println("Finding Instructor Detail By ID: " +theID);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theID);
		System.out.println("Retrieved Instructor Details: " +tempInstructorDetail);
		System.out.println("Associated Instructor: " +tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 1;
		System.out.println("Deleting Instructor ID: " +theID);
		appDAO.deleteInstructorById(theID);
		System.out.println("Done!!!");
	}

	private void findInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theID = 1;
		System.out.println("Finding Instructor by ID: " +theID);
		Instructor tempInstructor = appDAO.findInstanceById(theID);
		System.out.println("Instructor : \n" +tempInstructor);
		System.out.println("Associated Instructor Details: \n" +tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Instructor tempInstructor = new Instructor("Sundhar", "S G", "sundhargopal462@outlook.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("https://www,youtube.com/sundhar_sg/channel", "Full Stack Java Development");
		Instructor tempInstructor1 = new Instructor("Kishore", "K", "kishorekannan096@gmail.com");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("https://www,youtube.com/kishore_k/channel", "Cloud Development");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		System.out.println("Saving Instructor: " + tempInstructor);
		System.out.println("Saving Instructor: " + tempInstructor1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);
		System.out.println("Done!!!");
	}
}
