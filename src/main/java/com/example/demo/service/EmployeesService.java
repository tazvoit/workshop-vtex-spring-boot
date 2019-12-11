package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employees;

public interface EmployeesService {
	
	public abstract List<Employees> listAllEmployees();
	
	public abstract Employees addEmployee(Employees employee);
	
	public abstract int removeEmployee(int id);
	
	public abstract Employees updateEmployee(Employees employee);
	
	public abstract Employees findEmployeeById(int id);

}
