package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/addEmp")
	public String addEmp(@RequestBody List<Employee> emp)
	{
		return employeeService.addEmployee(emp);
	}
	
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmp()
	{
		
		return employeeService.getAllEmployee();
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id)
	{
		return employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/updateEmp")
	public String updateEmp(@RequestBody Employee emp) 
	{
		return employeeService.updateEmployee(emp);
	}
}
