package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/add")
	@ApiOperation(value = "Employee Creation API",
    notes = "Please provide all the info for Employee account creation",
    response = Employee.class)
	public ResponseEntity<String> createEmployee(@RequestBody Employee request) {
		String response = employeeService.addEmployee(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/get")
	@ApiOperation(value = "Employees list fetching",
    notes = "Please provide all the info for fetching employees list",
    response = Employee.class)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> response = employeeService.getEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/employeeData/{employeeId}")
	@ApiOperation(value = "Employee data fetching with employee ID ",
    notes = "Please provide employee id for fetching employee records",
    response = Employee.class)
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

	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		String response = employeeService.updateData(employee);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/update/data/{employeeId}/{employeeName}")
	public ResponseEntity<String> updateEmployeeNameById(@PathVariable("employeeId") Integer employeeId,
			@PathVariable("employeeName") String employeeName) {
		String response = employeeService.updateEmployeeName(employeeId, employeeName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		String response = employeeService.deleteEmployee(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
