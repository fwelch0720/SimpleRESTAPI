package com.Binary.RestCRUD.service;

import java.util.List;

import com.Binary.RestCRUD.entities.Employee;

public interface EmployeeService {
	
	List<Employee>getAllEmployees();
	
public Employee findById(int theId);
	
	public Employee save(Employee employee);
	
	public void deleteById(int id);

}
