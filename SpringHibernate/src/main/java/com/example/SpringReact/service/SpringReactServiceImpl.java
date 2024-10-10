package com.example.SpringReact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.SpringReact.entity.Employee;
import com.example.SpringReact.entity.SpringReactDAO;

@Component
public class SpringReactServiceImpl implements SpringReactService {
	
	private SpringReactDAO springReactDAO;
	
	@Autowired
	public SpringReactServiceImpl(SpringReactDAO thisspringReactDAO) {
		springReactDAO=thisspringReactDAO;
	}

	

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		springReactDAO.saveEmployee(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		
		return springReactDAO.getAllEmployees();
	}



	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return springReactDAO.findEmployeeById(id);
	}



	@Override
	public void deleteByEmployeeId(int id) {
		// TODO Auto-generated method stub
		springReactDAO.deleteEmployee(id);
		
	}



	@Override
	public void deleteEmployeeByName(String name) {
		// TODO Auto-generated method stub
		springReactDAO.deleteEmployeeByName(name);
	}


}
