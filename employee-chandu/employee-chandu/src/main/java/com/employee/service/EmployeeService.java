package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {

	String addEmployee(Employee employee);

	List<Employee> getEmployees();

	Employee getEmployeeDetailsById(Integer employeeId);

	List<Employee> getEmployeeDetailsByName(String employeeName);

	String updateData(Employee employee);

	String deleteEmployee(Integer employeeId);

	String updateEmployeeName(Integer employeeId, String employeeName);

}
