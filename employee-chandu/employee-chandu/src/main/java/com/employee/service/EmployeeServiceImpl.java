package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String addEmployee(Employee employee) {
		Employee employeeResponse = employeeRepository.save(employee);
		if (employeeResponse == null) {
			return "Employee data not saved";
		}
		return "Employee Data saved successfully";
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		if (null == employees || employees.isEmpty()) {
			throw new RuntimeException("Data is empty");
		}
		return employees;
	}

	@Override
	public Employee getEmployeeDetailsById(Integer employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (!employee.isPresent()) {
			throw new RuntimeException("Data is not exists");
		}
		return employee.get();
	}

	@Override
	public List<Employee> getEmployeeDetailsByName(String employeeName) {
		Optional<List<Employee>> response = employeeRepository.findByEmployeeName(employeeName);
		if (!response.isPresent()) {
			throw new RuntimeException("Data is not exists");
		}
		return response.get();
	}
}
