package com.shri.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.shri.demo.pojo.Employee;
import com.shri.demo.pojo.EmployeeAdress;

public interface EmployeeService {
	public Employee save(Employee employee);
	public List<Employee> findAll();
	public Optional<Employee> findById(String empId);
	public Employee findBydesgn(String desgn);
	public Employee deleteByempId(String empId);
	public Employee updateByempId(String empId, Employee updatedEmployee);
    public List< Employee> getHighestPaidPerDepartment();
	Employee getHigestSalary();
	Employee updateEmployeeAdress(String empId, EmployeeAdress adress);
   
	
}
