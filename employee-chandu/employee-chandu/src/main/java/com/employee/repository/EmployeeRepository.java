package com.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Optional<List<Employee>> findByEmployeeName(String employeeName);

	@Query("Select e from Employee e where e.employeeName = :employeeName")
	Optional<List<Employee>> getByEmployeeName(String employeeName);

	@Modifying
	@Query("Update Employee e set e.employeeName = :employeeName where e.employeeId = :employeeId")
	void updateName(Integer employeeId, String employeeName);

	//SQL Queries syntax
	//@Query(value = "Select * from employee_table where employee_name = :employeeName", nativeQuery = true)
	//Optional<List<Employee>> getByEmployeeName(String employeeName);

}
