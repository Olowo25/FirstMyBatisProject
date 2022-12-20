package com.kambok.spring.boot.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kambok.spring.boot.entity.Employee;
import com.kambok.spring.boot.repository.Employeerepository;

@Service
public class EmployeeService {
@Autowired
Employeerepository employeerepository;

public Employee getEmployee(String id ) {
	// Search
	Map<String, Object> map =employeerepository.findById(id );
	// Get value from Map
	String employeeId = (String) map.get("id" );
	String name = (String) map.get("name" );
	int age = (Integer) map.get("age" );
	// Set the Employee class to a value
	Employee employee = new Employee();
	employee .setEmployeeId(employeeId );
	employee .setEmployeeName(name );
	employee .setEmployeeAge(age );
	
	return employee ;
	}


}
