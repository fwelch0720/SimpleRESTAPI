package com.Binary.RestCRUD.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Binary.RestCRUD.entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getAllEmployees() {

		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public Employee save(Employee employee) {

		Employee dbEmployee = entityManager.merge(employee);
		return dbEmployee;
	}

	@Override
	public void deleteById(int id) {

		Employee theEmployee = entityManager.find(Employee.class, id);
		entityManager.remove(theEmployee);

	}

}
