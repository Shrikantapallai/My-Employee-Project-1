package com.shri.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shri.demo.exceptonHandler.ResourceNotFoundException;
import com.shri.demo.pojo.Employee;
import com.shri.demo.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeRepository employeeRepository;
	
	  @Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}

	@Override
	public Employee save(Employee employee) {
		employee.setEmpId(UUID.randomUUID().toString());
		Employee emp = employeeRepository.save(employee);
		return emp;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
		 
	}

	@Override
	public Optional<Employee> findById(String empId) {
		return employeeRepository.findById(empId);
		 
	}

	@Override
	public Employee findBydesgn(String desgn) {
		return  employeeRepository.findBydesgn(desgn);
		
	}

	@Override
	public Employee deleteByempId(String empId) {
		Optional<Employee>empopt=employeeRepository.findById(empId);
		if(empopt.isPresent()) {
			Employee emp=empopt.get();
			employeeRepository.deleteById(empId);
			return emp;
		}
		return null; 
	}

	@Override
	public Employee updateByempId(String empId,Employee updatedEmployee) {
		
		return employeeRepository.findById(empId).map(existingEmployee ->{
			existingEmployee.setEmpName(updatedEmployee.getEmpName());
			existingEmployee.setDesgn(updatedEmployee.getDesgn());
			existingEmployee.setLocation(updatedEmployee.getLocation());
			existingEmployee.setSalary(updatedEmployee.getSalary());
			return employeeRepository.save(existingEmployee);
		}).orElseThrow(()->new ResourceNotFoundException("Employee not found with id :"+empId));
	}

	
}
