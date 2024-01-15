package com.employee.dto;

import org.apache.ibatis.type.Alias;

@Alias("employee")
public class EmployeeDTO {
	private String eno;
	private String name;
	private String department;
	private int positionNo;
	private int salary;


	
	public EmployeeDTO(String eno, String name, String department, int positionNo, int salary) {
		super();
		this.eno = eno;
		this.name = name;
		this.department = department;
		this.positionNo = positionNo;
		this.salary = salary;
	}

	public EmployeeDTO() {  }


	public String getEno() {
		return eno;
	}


	public void setEno(String eno) {
		this.eno = eno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public int getPositionNo() {
		return positionNo;
	}


	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [eno=" + eno + ", name=" + name + ", department=" + department + ", positionNo="
				+ positionNo + ", salary=" + salary + "]";
	}	
	
	
	
}

