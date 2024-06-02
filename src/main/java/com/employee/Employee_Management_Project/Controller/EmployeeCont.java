package com.employee.Employee_Management_Project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Employee_Management_Project.Entity.Employee;
import com.employee.Employee_Management_Project.Service.EmployeeServiceImpl;


@RestController
@RequestMapping("/emp")
public class EmployeeCont {
	
	@Autowired
	public EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping("/addemp")
	public Employee addEmp(@RequestBody Employee emp) {
		Employee employee=employeeServiceImpl.addEmployee(emp);
		return employee;
	}
	
	@GetMapping("/getemp/{id}")
	public Optional<Employee> getEmp(@PathVariable int id) {
		Optional<Employee> emp=employeeServiceImpl.findEmployee(id);
		return emp;
	}
	@GetMapping("/getall")
	public List<Employee> getAllEmployees() {
		List<Employee> emp =employeeServiceImpl.getAllEmployes();
		return emp;
	}
	@DeleteMapping("/deleteemp/{id}")
	public String deleteEmp(@PathVariable int id) {
		employeeServiceImpl.removeEmployee(id);
		return null;
	}
	
	@PutMapping("/editemp/{id}")
	public String editEmp(@PathVariable int id, @RequestBody Employee employee) {
		employeeServiceImpl.updateEmployee(id, employee);
		
		return null;
	}
	
	

	
}
