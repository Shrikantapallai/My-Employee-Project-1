package com.shri.demo.pojo;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Employee_table")
public class Employee {
  @Id
  @Column(name="emp_id")	
  private String empId;
  @Column(name="emp_name")
  private String empName;
  @Column(name="emp_degn")
  private String desgn;
  @Column(name="emp_salary")
  private double salary;
  @Column(name="emp_location")
  private String location;
  
  public Employee() {
	  
  }
  
public Employee(String empId, String empName, String desgn, double salary, String location) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.desgn = desgn;
	this.salary = salary;
	this.location = location;
}
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getDesgn() {
	return desgn;
}
public void setDesgn(String desgn) {
	this.desgn = desgn;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", desgn=" + desgn + ", salary=" + salary
			+ ", location=" + location + "]";
}
  
  
}
