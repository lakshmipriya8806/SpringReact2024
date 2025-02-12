package com.example.SpringReact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringReact.entity.Employee;
import com.example.SpringReact.service.SpringReactService;

@CrossOrigin("*")
@RestController
public class SpringRestController {
	

	private SpringReactService springService;
	
	@Autowired 
	public SpringRestController(SpringReactService springReactService) {
		this.springService=springReactService;
	}
	
	
	
	@RequestMapping("/")
	
	public String test() {
		return "Hello World";
	}

	@GetMapping("/employees")
	//@ResponseBody-- not required as its a restcontroller
	public List<Employee> getEmployees() {
		List<Employee> employees=springService.getAllEmployees();
		
		return employees;
	}
	
	@PutMapping("/employees/{id}")
	//@ResponseBody--not required as its a RestController
	public void updateEmployeeById(@PathVariable int id,@RequestBody Employee updateemployee) {
		Employee employee=springService.findEmployeeById(id);
		employee.setFirstname(updateemployee.getFirstname());
		employee.setLastname(updateemployee.getLastname());
		employee.setEmail(updateemployee.getEmail());
		
		springService.saveEmployee(employee);
	}
	
	@GetMapping("/employees/{id}")
	//@ResponseBody
	public Employee getEmployeeById(@PathVariable int id) {
		Employee employee=springService.findEmployeeById(id);
		
		/*
		 * if(employee==null) { employee.setFirstname("No Data Found"); }
		 */
		return employee;
	}
	
	
	@PostMapping("/employees")
	public void saveEmployees(@RequestBody Employee employee) {
		springService.saveEmployee(employee);		
		
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployeeByid(@PathVariable int id) {
		springService.deleteByEmployeeId(id);
	}
	
	@DeleteMapping("/employees/name/{name}")
	public void deleteEmployeeByid(@PathVariable String name) {
		System.out.println("Inside delete"+name);
		springService.deleteEmployeeByName(name);
	}
}
