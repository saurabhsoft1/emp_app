package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	public String addEmployee(List<Employee> emp)
	{
		
		List<Employee> list1= (List<Employee>) employeeRepository.saveAll(emp);
		return list1.size() + ":recorded added sucessfully";
	}
	
	public List<Employee> getAllEmployee()
	{
		return  employeeRepository.findAll();
	}
	
	public String deleteEmployee(int id)
	{
		employeeRepository.deleteById(id);
		return "Record Deleted Sucessfully";
	}
	
	public String updateEmployee(Employee emp) 
	{
		Employee emp1 = employeeRepository.save(emp);
		return "Emp ID " + emp1.getId() + " has updated sucessfully";
	}
}
