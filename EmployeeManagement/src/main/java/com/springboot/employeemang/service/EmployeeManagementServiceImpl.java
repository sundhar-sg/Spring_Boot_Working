package com.springboot.employeemang.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.employeemang.dto.AttendanceDTO;
import com.springboot.employeemang.dto.DepartmentDTO;
import com.springboot.employeemang.dto.EmployeeDTO;
import com.springboot.employeemang.dto.SalaryDTO;
import com.springboot.employeemang.model.Attendance;
import com.springboot.employeemang.model.Department;
import com.springboot.employeemang.model.Employee;
import com.springboot.employeemang.model.Salary;
import com.springboot.employeemang.repository.AttendanceRepository;
import com.springboot.employeemang.repository.DepartmentRepository;
import com.springboot.employeemang.repository.EmployeeRepository;
import com.springboot.employeemang.repository.SalaryRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private AttendanceRepository attendanceRepo;
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private SalaryRepository salaryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		Department department = this.modelMapper.map(findDepartmentByID(employeeDTO.getDepartment().getDept_id()), Department.class);
		Salary salary = this.modelMapper.map(employeeDTO.getSalary(), Salary.class);
		if(!this.entityManager.contains(department))
			department = this.entityManager.merge(department);
		Employee employee = new Employee();
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setGender(employeeDTO.getGender());
		employee.setDepartment(department);
		employee.setSalary(salary);
		this.employeeRepo.save(employee);
		
//		Department department = this.modelMapper.map(findDepartmentByID(employeeDTO.getDepartment().getDept_id()), Department.class);
//		if(department == null)
//			throw new IllegalArgumentException("Department ID must be provided");
//		List<Employee> departmentEmployees = department.getEmployee();
//		Employee employee = this.modelMapper.map(employeeDTO, Employee.class);
//		if(departmentEmployees != null && !departmentEmployees.contains(employee))
//			throw new IllegalArgumentException("Employee is not referenced by the Department");
//		if(!this.entityManager.contains(department))
//			department = this.entityManager.merge(department);
//		employee.setDepartment(department);
//		this.employeeRepo.save(employee);
		
		return employeeDTO;
	}

	@Override
	public EmployeeDTO findEmployeeByID(int employeeID) {
		// TODO Auto-generated method stub
		return this.modelMapper.map(this.employeeRepo.findById(employeeID).get(), EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> findAllEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();
		for(Employee employee : this.employeeRepo.findAll()) {
			employeeDTOList.add(this.modelMapper.map(employee, EmployeeDTO.class));
		}
		return employeeDTOList;
	}

	@Override
	@Transactional
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		Department department = this.departmentRepo.findById(employeeDTO.getDepartment().getDept_id()).get();
		Salary salary = this.employeeRepo.findById(employeeDTO.getEmp_id()).get().getSalary();
		System.out.println(salary);
		Employee employee = this.modelMapper.map(employeeDTO, Employee.class);
		this.salaryRepo.deleteById(salary.getSalary_id());
		employee.setDepartment(department);
		this.employeeRepo.save(employee);
		return employeeDTO;
	}

	@Override
	public void deleteEmployee(int employeeID) {
		// TODO Auto-generated method stub
		this.employeeRepo.deleteById(employeeID);
	}

	@Override
	public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
		// TODO Auto-generated method stub
		this.departmentRepo.save(this.modelMapper.map(departmentDTO, Department.class));
		return departmentDTO;
	}

	@Override
	public DepartmentDTO findDepartmentByID(int deptID) {
		// TODO Auto-generated method stub
		return this.modelMapper.map(this.departmentRepo.findById(deptID), DepartmentDTO.class);
	}
	
	@Override
	@Transactional
	public DepartmentDTO findDepartmentWithEmployees(int deptID) {
		Attendance attendance = new Attendance();
		if(!this.entityManager.contains(attendance))
			attendance = this.entityManager.merge(attendance);
		TypedQuery<Department> departmentQuery = this.entityManager.createQuery("SELECT d FROM Department d JOIN FETCH d.employee WHERE d.dept_id = :id", Department.class);
		departmentQuery.setParameter("id", deptID);
		Department department = departmentQuery.getSingleResult();
		System.out.println("Department Employees: " +department.getEmployee());
		return this.modelMapper.map(department, DepartmentDTO.class);
	}

	@Override
	public List<DepartmentDTO> findAllDepartments() {
		// TODO Auto-generated method stub
		List<DepartmentDTO> departmentDTOList = new ArrayList<>();
		for(Department department : this.departmentRepo.findAll()) {
			departmentDTOList.add(this.modelMapper.map(department, DepartmentDTO.class));
		}
		return departmentDTOList;
	}

	@Override
	public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO) {
		// TODO Auto-generated method stub
		this.departmentRepo.save(this.modelMapper.map(departmentDTO, Department.class));
		return departmentDTO;
	}

	@Override
	@Transactional
	public void deleteDepartment(int deptID) {
		// TODO Auto-generated method stub
		Department department = this.departmentRepo.findById(deptID).get();
		for(Employee employee : department.getEmployee()) {
			employee.setDepartment(null);
			this.employeeRepo.save(employee);
		}
		this.departmentRepo.deleteById(deptID);
	}

	@Override
	@Transactional
	public AttendanceDTO addAttendance(AttendanceDTO attendanceDTO) {
		// TODO Auto-generated method stub
		Employee employee = this.employeeRepo.findById(attendanceDTO.getEmployeeID()).get();
		if(!this.entityManager.contains(employee))
			employee = this.entityManager.merge(employee);
		Attendance attendance = new Attendance();
		attendance.setCurrentDate(attendanceDTO.getCurrentDate());
		attendance.setAttendanceStatus(attendanceDTO.getAttendanceStatus());
		attendance.setEmployee(employee);
		this.attendanceRepo.save(attendance);
		return attendanceDTO;
	}

	@Override
	public AttendanceDTO findAttendanceByID(int attendanceID) {
		// TODO Auto-generated method stub
		return this.modelMapper.map(this.attendanceRepo.findById(attendanceID).get(), AttendanceDTO.class);
	}

	@Override
	public List<AttendanceDTO> findAllAttendancesForEmployee(int employeeID) {
		// TODO Auto-generated method stub
		List<AttendanceDTO> attendanceForEmployee = new ArrayList<>();
		for(Attendance attendance : this.attendanceRepo.findAttendancesbyEmployeeID(employeeID)) {
			attendanceForEmployee.add(this.modelMapper.map(attendance, AttendanceDTO.class));
		}
		return attendanceForEmployee;
	}

	@Override
	public AttendanceDTO updateAttendance(AttendanceDTO attendanceDTO) {
		// TODO Auto-generated method stub
		Employee employee = this.employeeRepo.findById(attendanceDTO.getEmployeeID()).get();
		Attendance attendance = this.modelMapper.map(attendanceDTO, Attendance.class);
		attendance.setEmployee(employee);
		this.attendanceRepo.save(attendance);
		return attendanceDTO;
	}

	@Override
	public void deleteAttendance(int attendanceID) {
		// TODO Auto-generated method stub
		this.attendanceRepo.deleteById(attendanceID);
	}

	@Override
	public SalaryDTO addSalary(SalaryDTO salaryDTO) {
		// TODO Auto-generated method stub
		Salary salary = this.modelMapper.map(salaryDTO, Salary.class);
		Employee employee = this.employeeRepo.findById(salaryDTO.getEmployeeID()).get();
		employee.setSalary(salary);
		this.employeeRepo.save(employee);
		return salaryDTO;
	}

	@Override
	public SalaryDTO findSalaryByID(int salaryID) {
		// TODO Auto-generated method stub
		return this.modelMapper.map(this.salaryRepo.findById(salaryID).get(), SalaryDTO.class);
	}

	@Override
	public List<SalaryDTO> findAllSalaries() {
		// TODO Auto-generated method stub
		List<SalaryDTO> salariesList = new ArrayList<>();
		for(Salary salary : this.salaryRepo.findAll()) {
			salariesList.add(this.modelMapper.map(salary, SalaryDTO.class));
		}
		return salariesList;
	}

	@Override
	public SalaryDTO updateSalary(SalaryDTO salaryDTO) {
		// TODO Auto-generated method stub
		this.salaryRepo.save(this.modelMapper.map(salaryDTO, Salary.class));
		return salaryDTO;
	}

	@Override
	@Transactional
	public void deleteSalary(int salaryID) {
		// TODO Auto-generated method stub
		Salary salary = this.salaryRepo.findById(salaryID).get();
		Employee employee = salary.getEmployee();
		employee.setSalary(null);
		this.employeeRepo.save(employee);
		this.salaryRepo.deleteById(salaryID);
	}

}