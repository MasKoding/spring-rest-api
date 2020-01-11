package com.learn.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.tutorial.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	 Employee findByEmployeeName(String employeeName);
}
