package com.example.SpringReact.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
public class SpringReactDAOImpl implements SpringReactDAO {
	
	private EntityManager entityManager;

	@Autowired
	public SpringReactDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> employeeList=entityManager.createQuery("from Employee", Employee.class);
		List<Employee> employees=employeeList.getResultList();
		
		return employees;
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub	
		if(employee.getId()==0) {
		entityManager.persist(employee);
		}
		else {
			entityManager.merge(employee);
		}
		
	}

	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee employee=entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Employee employee=entityManager.find(Employee.class,id);
		entityManager.remove(employee);
		
	}

	@Override
	public Employee updateEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee employee=entityManager.find(Employee.class, id);
		return null;
	}

	@Override
	@Transactional
	public void deleteEmployeeByName(String name) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside DAOIMPL"+name);
		
		 String jpql = "SELECT e FROM Employee e WHERE e.firstname = :name";
		  TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
		  query.setParameter("name", name);

		List<Employee> employees=query.getResultList();
		
		for(Employee employee: employees) {
			entityManager.remove(employee);
		}
		 //
		
	}

}
