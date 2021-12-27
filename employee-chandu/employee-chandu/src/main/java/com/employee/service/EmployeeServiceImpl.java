package com.employee.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
@Transactional
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
		// Optional<List<Employee>> response =
		// employeeRepository.findByEmployeeName(employeeName);
		Optional<List<Employee>> response = employeeRepository.getByEmployeeName(employeeName);
		if (!response.isPresent()) {
			throw new RuntimeException("Data is not exists");
		}
		return response.get();
	}

	@Override
	public String updateData(Employee employee) {
		Optional<Employee> employeeResponse = employeeRepository.findById(employee.getEmployeeId());
		if (!employeeResponse.isPresent()) {
			throw new RuntimeException("Data is not exists");
		}

		if (employee.getEmployeeName() != null) {
			employeeResponse.get().setEmployeeName(employee.getEmployeeName());
		}
		if (employee.getLoginId() != null) {
			employeeResponse.get().setLoginId(employee.getLoginId());
		}
		if (employee.getMobileNumber() != null) {
			employeeResponse.get().setMobileNumber(employee.getMobileNumber());
		}
		if (employee.getPassword() != null) {
			employeeResponse.get().setPassword(employee.getPassword());
		}
		employeeRepository.save(employeeResponse.get());
		return "Updated data successfully";
	}

	@Override
	public String deleteEmployee(Integer employeeId) {
		Optional<Employee> employeeResponse = employeeRepository.findById(employeeId);
		if (!employeeResponse.isPresent()) {
			throw new RuntimeException("Data is not exists");
		}
		employeeRepository.deleteById(employeeId);
		return "Deleted successffully";
	}

	@Override
	public String updateEmployeeName(Integer employeeId, String employeeName) {
		employeeRepository.updateName(employeeId, employeeName);
		return "Updated name successfully";
	}
}
