package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employees;
import com.example.demo.repository.EmployeesJpaRepository;
import com.example.demo.service.EmployeesService;

@Service
@Qualifier("employeeService")
public class EmployeesServiceImpl implements EmployeesService{

	
	@Autowired
	@Qualifier("employeesJpaRepository")
	private EmployeesJpaRepository employeesJpaRepository;
	
	@Override
	public List<Employees> listAllEmployees() {
		return employeesJpaRepository.findAll();
	}

	@Override
	public Employees addEmployee(Employees employee) {
		return employeesJpaRepository.save(employee);
	}

	@Override
	public int removeEmployee(int id) {
		employeesJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Employees updateEmployee(Employees employee) {
		return employeesJpaRepository.save(employee);
	}

	@Override
	public Employees findEmployeeById(int id) {
		return employeesJpaRepository.findById(id).get();
	}
}