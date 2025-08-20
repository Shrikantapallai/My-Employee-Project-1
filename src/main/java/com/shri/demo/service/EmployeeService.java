package com.shri.demo.service;

import java.util.List;
import java.util.Optional;

import com.shri.demo.pojo.Employee;

public interface EmployeeService {
	public Employee save(Employee employee);
	public List<Employee> findAll();
	public Optional<Employee> findById(String empId);
	public Employee findBydesgn(String desgn);
	public Employee deleteByempId(String empId);
	Employee updateByempId(String empId, Employee updatedEmployee);
	
	
}
