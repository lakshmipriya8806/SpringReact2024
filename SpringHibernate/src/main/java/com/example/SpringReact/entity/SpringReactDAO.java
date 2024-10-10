package com.example.SpringReact.entity;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public interface SpringReactDAO {
	
	List<Employee> getAllEmployees();

	void saveEmployee(Employee employee);
	
	Employee findEmployeeById(int id);
	
	void deleteEmployee(int id);
	
	Employee updateEmployeeById(int id);
	
	void deleteEmployeeByName(String name);

}
