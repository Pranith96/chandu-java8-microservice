import java.util.function.Supplier;

public class EmployeeSupplier {

	public static void main(String[] args) {

		Supplier<Employee> employee = () -> {
			return new Employee("1", "ABC", "25");
		};

		Employee data = employee.get();
		System.out.println(data.getEmployeeId() + " " + data.getEmployeeName() + " " + data.getAge());
	}

}
