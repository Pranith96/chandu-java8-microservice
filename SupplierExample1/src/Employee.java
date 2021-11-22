
public class Employee {

	private String employeeId;
	private String employeeName;
	private String age;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", age=" + age + "]";
	}

	public Employee() {
	}

	public Employee(String employeeId, String employeeName, String age) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.age = age;
	}

}
