package com.springboot.employeemang.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class DepartmentDTO {

	@NotNull
	private int dept_id;
	
	@NotNull
	@NotEmpty
	private String dept_name;

	public DepartmentDTO(@NotNull @NotEmpty String dept_name) {
		super();
		this.dept_name = dept_name;
	}

	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
}