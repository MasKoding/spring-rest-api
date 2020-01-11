package com.learn.tutorial.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.tutorial.model.Employee;
import com.learn.tutorial.repository.EmployeeRepository;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public ResponseEntity<Object> getAll(){
		HashMap<String, Object> employee = new HashMap<String, Object>();
		employee.put("data", employeeRepo.findAll());
		employee.put("status", HttpStatus.OK);
		
		return ResponseEntity.ok(employee);
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public ResponseEntity<Object> save(@Valid @RequestBody Employee newEmployee){
		HashMap<String, Object> employee = new HashMap<String, Object>();
		employeeRepo.save(newEmployee);
		employee.put("status", HttpStatus.OK);
		
		return ResponseEntity.ok(employee);
	}
	
	@RequestMapping(value = "/edit",method = RequestMethod.PUT)
	public ResponseEntity<Object> edit(@Valid @RequestBody Employee newEmployee){
		HashMap<String, Object> employee = new HashMap<String, Object>();
		newEmployee.getId();
		employeeRepo.save(newEmployee);
		employee.put("status", HttpStatus.OK);
		
		return ResponseEntity.ok(employee);
		
	}
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable long id){
		HashMap<String, Object> employee = new HashMap<String, Object>();
		employeeRepo.deleteById(id);
		employee.put("status", HttpStatus.OK);
		return ResponseEntity.ok(employee);
	}
	@RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
	public ResponseEntity<Object> findById(@PathVariable long id){
		HashMap<String, Object> employee = new HashMap<String, Object>();
		employee.put("data", employeeRepo.findById(id));
		employee.put("status", HttpStatus.OK);
		
		return ResponseEntity.ok(employee);
	}
	@RequestMapping(value = "/findByName",method = RequestMethod.GET)
	public ResponseEntity<Object> findById(@RequestBody Employee findEmployee){
		HashMap<String, Object> employee = new HashMap<String, Object>();
		employee.put("data", employeeRepo.findByEmployeeName(findEmployee.getEmployeeName()));
		employee.put("status", HttpStatus.OK);
		
		return ResponseEntity.ok(employee);
	}
}
