package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		String response = employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> response = employeeService.getEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/employeeData/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") Integer employeeId) {
		Employee response = employeeService.getEmployeeDetailsById(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/data")
	public ResponseEntity<Employee> getEmployeeData(@RequestParam("employeeId") Integer employeeId) {
		Employee response = employeeService.getEmployeeDetailsById(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/data/name")
	public ResponseEntity<List<Employee>> getEmployee(@RequestParam("employeeName") String employeeName) {
		List<Employee> response = employeeService.getEmployeeDetailsByName(employeeName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
