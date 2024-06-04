package com.Binary.RestCRUD.controllers;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Binary.RestCRUD.dao.EmployeeDao;
import com.Binary.RestCRUD.dao.EmployeeDaoImpl;
import com.Binary.RestCRUD.entities.Employee;
import com.Binary.RestCRUD.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return  employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee findbyId(@PathVariable int id ) {
		Employee theEmployee = employeeService.findById(id);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee with id " + id + " doesnt exsist");
		}
		
		return theEmployee;
		
	}
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody Employee theEmployee, @PathVariable int id) {
		
	Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		Employee tempEmployee = employeeService.findById(id);
		
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id " + id + " does not exsist");
		}
		 employeeService.deleteById(id);
		 return "Deleted employee with id - " + id;
	}
	
	
	

}
