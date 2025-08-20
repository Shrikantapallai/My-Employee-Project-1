package com.shri.demo.repository;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shri.demo.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,String>{

	 Employee findBydesgn(String desgn);
	 @Query(value = "SELECT e.* " +
             "FROM Employee_Table e " +
             "JOIN (SELECT emp_degn, MAX(emp_salary) AS max_salary " +
             "      FROM Employee_Table " +
             "      GROUP BY emp_degn) m " +
             "ON e.emp_degn = m.emp_degn AND e.emp_salary = m.max_salary",
     nativeQuery = true)
	    List<Employee> findHighestPaidPerDepartment();
	 
	 
	 @Query(value = "SELECT * FROM Employee_Table e " +
             "WHERE e.emp_salary = (SELECT MAX(emp_salary) FROM Employee_Table)", 
     nativeQuery = true)
	 Employee findHigestSalary();
	
}
