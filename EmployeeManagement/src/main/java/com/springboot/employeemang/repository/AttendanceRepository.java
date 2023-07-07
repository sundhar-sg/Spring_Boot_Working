package com.springboot.employeemang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.employeemang.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

	@Query(value = "SELECT * FROM Attendance WHERE employee_id = :employeeID", nativeQuery = true)
	List<Attendance> findAttendancesbyEmployeeID(@Param("employeeID") int employeeID);
}