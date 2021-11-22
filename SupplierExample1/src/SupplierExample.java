import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample implements Supplier<Integer> {

	@Override
	public Integer get() {
		return new Random().nextInt();
	}

}
