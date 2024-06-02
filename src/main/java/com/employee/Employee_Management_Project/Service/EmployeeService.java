package com.employee.Employee_Management_Project.Service;

import java.util.List;
import java.util.Optional;

import com.employee.Employee_Management_Project.Entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public Optional<Employee> findEmployee(int id);
	
	public List<Employee> getAllEmployes();
	
	public String removeEmployee(int id);
	
	public String updateEmployee(int id,Employee employee);

}
