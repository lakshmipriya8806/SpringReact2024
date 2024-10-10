package com.example.SpringReact;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	public SpringRestController(SpringReactService thisspringService) {
		springService=thisspringService;
	}
	
	
	@RequestMapping("/")
	@ResponseBody
	public String test() {
		return "Hello World";
	}

	@GetMapping("/employees")
	//@ResponseBody-- not required as its a restcontroller
	public List<Employee> getEmployees() {
		List<Employee> employees=springService.getAllEmployees();
		
		return employees;
	}
	
	@GetMapping("/employees/{id}")
	//@ResponseBody
	public Employee getEmployeeById(@PathVariable int id) {
		Employee employee=springService.findEmployeeById(id);
		
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
	
	@DeleteMapping("/employee/name/{name}")
	public void deleteEmployeeByid(@PathVariable String name) {
		System.out.println("Inside delete"+name);
		springService.deleteEmployeeByName(name);
	}
}
