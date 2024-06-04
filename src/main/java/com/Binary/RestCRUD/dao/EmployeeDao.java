package com.Binary.RestCRUD.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Binary.RestCRUD.entities.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployees();
	
	public Employee findById(int theId);
	
	public Employee save(Employee employee);
	
	public void deleteById(int id);
	
}
