package com.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Program {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PROGRAM_SEQ")
	private int id;

	@Column(name = "PROGRAM_NAME")
	private String programName;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "PROGRAM_EMPLOYEE", joinColumns = @JoinColumn(name = "PROGRAM_ID"), inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
	private List<Employee> employees = new ArrayList<>();

	public Program() {
		super();
	}

	public Program(String programName) {
		super();
		this.programName = programName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	@Override
	public String toString() {
		return "Program id=" + id + ", programName=" + programName;
	}

}
