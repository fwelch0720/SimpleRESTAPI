package com.Binary.RestCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Binary.RestCRUD.dao.EmployeeDao;
import com.Binary.RestCRUD.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee findById(int theId) {
		
		return employeeDao.findById(theId);
	}
	@Transactional
	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.save(employee);
	}
	
	@Transactional
	@Override
	public void deleteById(int id) {
		employeeDao.deleteById(id);
		
	}

}
