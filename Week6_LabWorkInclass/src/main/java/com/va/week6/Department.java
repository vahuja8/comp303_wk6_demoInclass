package com.va.week6;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
//@Table(name = "depart")
@Table
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// try flipping with Identity..
	private int deptno;

	@NotBlank(message = "Department Name is mandatory")
	private String deptname;

	@NotBlank(message = "Location is mandatory")
	private String location;

	public int getDeptno() {
		return deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public String getLocation() {
		return location;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Department() {
	
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptname=" + deptname + ", location=" + location + "]";
	}


}
