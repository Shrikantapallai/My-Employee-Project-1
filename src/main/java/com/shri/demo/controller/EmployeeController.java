package com.shri.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shri.demo.apiResponse.ApiResponse;
import com.shri.demo.exceptonHandler.ResourceNotFoundException;
import com.shri.demo.pojo.Employee;
import com.shri.demo.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
@RestController
public class EmployeeController {
	
	private EmployeeService employeeService;
	@Autowired
	private EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@PostMapping("/saveEmp")
	public ResponseEntity<ApiResponse<Employee>>saveEmployeeDetails(@RequestBody Employee employee){
		Employee saving=employeeService.save(employee);
		return new ResponseEntity<>(
				new ApiResponse<>("Employee saved successfully",true,saving),HttpStatus.CREATED);
	}
	
	@GetMapping("/getEmp")
	public ResponseEntity<ApiResponse<Employee>> getEmployeeById(@RequestParam("empId") String empId ){
		Employee employee = employeeService.findById(empId).orElseThrow(
				()->new ResourceNotFoundException("employee not found with id :"+empId));
				
		return ResponseEntity.ok(new ApiResponse<>("Employee found",true,employee));
		
	}
	
	@GetMapping("/allEmp")
	public ResponseEntity<ApiResponse<List<Employee>>> getallEmployees(){
		List<Employee>emp2=employeeService.findAll();
		if(emp2.isEmpty()) {
			throw new ResourceNotFoundException("no Employee found");
		}
		 return ResponseEntity.ok(
			        new ApiResponse<>("Employees fetched successfully", true, emp2)
			    );
		}
	
	@GetMapping("/getdesg")
	public ResponseEntity<Employee> getEmployeeBydesgn(@RequestParam("desgn")String desgn) {
		Employee em=employeeService.findBydesgn(desgn);
		if(em!=null) {
		
		return  new ResponseEntity<>(em,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		}
		
	@DeleteMapping("/delete/{empId}") 
	ResponseEntity<String>deleteEmployee(@PathVariable String empId){
		Optional<Employee>empdt= employeeService.findById(empId);
		if(empdt.isPresent()) {
			
			employeeService.deleteByempId(empId);
			return new ResponseEntity<>("employee with id :"+empId+" " +"deleted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Employee with id :"+empId+" "+"not found ",HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@PathVariable @Pattern(regexp = "^[A-Za-z0-9]+$")String empId,@RequestBody Employee updatedEmployee){
		Employee employee=employeeService.updateByempId(empId,updatedEmployee);
		return ResponseEntity.ok(employee);
	}
	@GetMapping("/highest-by-dept")
    public ResponseEntity<List< Employee>> getHighestByDepartment() {
        List< Employee> result = employeeService.getHighestPaidPerDepartment();
        return ResponseEntity.ok(result);
    }
	
	@GetMapping("/highest-salary")
	public ResponseEntity<Employee> getSalary() {
	    Employee highestSalary =  employeeService.getHigestSalary();

	    if (highestSalary != null) {
	        return new ResponseEntity<>(highestSalary, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
