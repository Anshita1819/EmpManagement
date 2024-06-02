package com.employee.Employee_Management_Project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Employee_Management_Project.Entity.Employee;
import com.employee.Employee_Management_Project.Repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	@Override
	public Employee addEmployee(Employee employee) {
		
		employeeRepo.save(employee);
		return employee;
	}

	@Override
	public Optional<Employee> findEmployee(int id) {
		Optional<Employee> emp=employeeRepo.findById(id);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployes() {
		List<Employee> empList=employeeRepo.findAll();
		return empList;
	}

	@Override
	public String removeEmployee(int id) {
		 employeeRepo.deleteById(id);
		return null;
	}

	@Override
	public String updateEmployee(int id,Employee updateEmp) {
		Optional<Employee> currentEmp= employeeRepo.findById(id);
	       Employee emp=currentEmp.get();
	       emp.setName(updateEmp.getName());
	       emp.setAddress(updateEmp.getAddress());
	       emp.setContactNo(updateEmp.getContactNo());
	       emp.setSalary(updateEmp.getSalary());
		   employeeRepo.save(emp);
		
		return null;
	}
	

}
