package com.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "employee_table")
@ApiModel(description = "Details About the Employee model")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	@ApiModelProperty(notes = "The Unique Employee Id auto-increment")
	private Integer employeeId;
	@Column(name = "employee_name")
	@ApiModelProperty(notes = "String as Employee name")
	private String employeeName;
	@Column(name = "mobile_number", length = 10)
	@ApiModelProperty(notes = "String as mobile number")
	private String mobileNumber;
	@Column(name = "login_id", unique = true)
	@ApiModelProperty(notes = "The Unique Login id")
	private String loginId;
	@Column(name = "password")
	@ApiModelProperty(notes = "The String as password")
	private String password;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee(Integer employeeId, String employeeName, String mobileNumber, String loginId, String password) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.mobileNumber = mobileNumber;
		this.loginId = loginId;
		this.password = password;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", mobileNumber="
				+ mobileNumber + ", loginId=" + loginId + ", password=" + password + "]";
	}

}
