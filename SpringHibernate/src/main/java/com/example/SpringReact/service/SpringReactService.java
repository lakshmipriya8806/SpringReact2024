package com.example.SpringReact.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringReact.entity.Employee;

@Component
public interface SpringReactService {
	
	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
	
	Employee findEmployeeById(int id);
	
	void deleteByEmployeeId(int id);
	
	void deleteEmployeeByName( String name);

}
