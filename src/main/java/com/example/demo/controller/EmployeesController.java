package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employees;
import com.example.demo.service.EmployeesService;

@RestController
@RequestMapping
public class EmployeesController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeesController.class);
    private SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); 

    @Autowired
    @Qualifier("employeeService")
    private EmployeesService employeesService;
    
    @Autowired
    private Validator validator;

    
	@GetMapping(path = "/employee/add", consumes = "application/json" , produces = "application/json")
	public Employees addEmployee(@RequestBody Employees employeeRequest){
		BeanPropertyBindingResult employeeRequestResult = new BeanPropertyBindingResult(new Employees(),"employeeRequest");
		validator.validate(employeeRequest, employeeRequestResult);
		
		if (!employeeRequestResult.hasErrors()) {
			employeeRequest = employeesService.addEmployee(employeeRequest);
			LOGGER.info("Employee add with id: "+ employeeRequest.getId());
			return employeeRequest;
		} else {
			LOGGER.error("[employeeRequestResult]: Total Errors [" + employeeRequestResult.getErrorCount() + "]" + 
		                 " Descripcion [" + employeeRequestResult.getFieldError() + "]");
			return null;
		}
		
		
	}
	
	@GetMapping(path = "/employee/all",produces = "application/json")
	public List<Employees> getAllBook() throws ParseException{
		LOGGER.info("Get All Employees!!!");
		return employeesService.listAllEmployees();	
	}
	
	@GetMapping(path = "/employee/{id}",produces = "application/json")
	public Employees getEmployee(@PathVariable int id) throws ParseException{
		LOGGER.info("Get a Employee with id:"+ id);
		return employeesService.findEmployeeById(id);	
	}

}
