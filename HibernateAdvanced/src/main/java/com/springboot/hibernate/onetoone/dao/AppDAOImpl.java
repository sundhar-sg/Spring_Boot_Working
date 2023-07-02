package com.springboot.hibernate.onetoone.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.hibernate.onetoone.entity.Course;
import com.springboot.hibernate.onetoone.entity.Instructor;
import com.springboot.hibernate.onetoone.entity.InstructorDetail;
import com.springboot.hibernate.onetoone.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AppDAOImpl implements AppDAO {

	private EntityManager entityManager;
	
	@Autowired
	public AppDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findInstanceById(int theID) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Instructor.class, theID);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theID) {
		// TODO Auto-generated method stub
		Instructor retrievedInstructor = this.entityManager.find(Instructor.class, theID);
		
		this.entityManager.remove(retrievedInstructor);
	}

	@Override
	public InstructorDetail findInstructorDetailById(int theID) {
		// TODO Auto-generated method stub
		return this.entityManager.find(InstructorDetail.class, theID);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailByID(int theID) {
		// TODO Auto-generated method stub
		InstructorDetail tempInstructorDetail = this.entityManager.find(InstructorDetail.class, theID);
		
		// Remove the associated object reference
		// Break the bi-directional link
		tempInstructorDetail.getInstructor().setInstructorDetail(null);
		this.entityManager.remove(tempInstructorDetail);
	}

	@Override
	public List<Course> findCoursesByInstructorID(int theID) {
		// TODO Auto-generated method stub
		TypedQuery<Course> query = this.entityManager.createQuery("from Course where instructor.id = :data", Course.class);
		query.setParameter("data", theID);
		List<Course> courses = query.getResultList();
		return courses;
	}

	@Override
	public Instructor findInstructorByIDJoinFetch(int theID) {
		// TODO Auto-generated method stub
		TypedQuery<Instructor> query = entityManager.createQuery("SELECT i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail WHERE i.id = :data", Instructor.class);
		query.setParameter("data", theID);
		Instructor retrievedInstructor = query.getSingleResult();
		return retrievedInstructor;
	}

	@Override
	@Transactional
	public void updateInstructor(Instructor theInstructor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(theInstructor);
	}

	@Override
	@Transactional
	public void updateCourse(Course theCourse) {
		// TODO Auto-generated method stub
		this.entityManager.merge(theCourse);
	}

	@Override
	public Course findCourseByID(int theID) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Course.class, theID);
	}

	@Override
	@Transactional
	public void deleteInstructor(int theID) {
		// TODO Auto-generated method stub
		Instructor tempInstructor = this.entityManager.find(Instructor.class, theID);
		List<Course> listCourses = tempInstructor.getCourses();
		for(Course course : listCourses) {
			course.setInstructor(null);
		}
		this.entityManager.remove(tempInstructor);
	}

	@Override
	@Transactional
	public void deleteCourse(int theID) {
		// TODO Auto-generated method stub
		Course tempCourse = this.entityManager.find(Course.class, theID);
		this.entityManager.remove(tempCourse);
	}

	@Override
	@Transactional
	public void saveCourse(Course theCourse) {
		// TODO Auto-generated method stub
		this.entityManager.persist(theCourse);
	}

	@Override
	public Course findCourseAndReviewsByCourseID(int theID) {
		// TODO Auto-generated method stub
		TypedQuery<Course> query = this.entityManager.createQuery("SELECT c FROM Course c JOIN FETCH c.reviews WHERE c.id = :data", Course.class);
		query.setParameter("data", theID);
		Course tempCourse = query.getSingleResult();
		return tempCourse;
	}

	@Override
	public Course findCourseAndStudentsByCourseID(int theID) {
		// TODO Auto-generated method stub
		TypedQuery<Course> query = this.entityManager.createQuery("SELECT c FROM Course c JOIN FETCH c.students WHERE c.id = :data", Course.class);
		query.setParameter("data", theID);
		Course course = query.getSingleResult();
		return course;
	}

	@Override
	public Student findStudentWithCoursesByStudentID(int theID) {
		// TODO Auto-generated method stub
		TypedQuery<Student> query = this.entityManager.createQuery("SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id = :data", Student.class);
		query.setParameter("data", theID);
		Student student = query.getSingleResult();
		return student;
	}

	@Override
	@Transactional
	public void updateStudent(Student theStudent) {
		// TODO Auto-generated method stub
		this.entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void deleteStudentByID(int theID) {
		// TODO Auto-generated method stub
		Student student = this.entityManager.find(Student.class, theID);
		this.entityManager.remove(student);
	}

}