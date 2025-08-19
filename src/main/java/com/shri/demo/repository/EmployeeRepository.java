package com.shri.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shri.demo.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,String>{

	 Employee findBydesgn(String desgn);
	
}
