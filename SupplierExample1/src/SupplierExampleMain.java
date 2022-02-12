import java.util.Random;
import java.util.function.Supplier;

public class SupplierExampleMain {

	public static void main(String[] args) {

		SupplierExample example = new SupplierExample();
		Integer i = example.get();
		System.out.println(i);

		Supplier<Integer> data = () -> new Random().nextInt();
		Integer k = data.get();
		System.out.println(k);
	}
}
