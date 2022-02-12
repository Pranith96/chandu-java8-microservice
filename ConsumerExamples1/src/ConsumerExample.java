import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println("hello: " + t);
	}
	
	public static void main(String[] args) {
		ConsumerExample consumerExample = new ConsumerExample();
		consumerExample.accept("Chandu");

		Consumer<String> result = t -> System.out.println("hello: " + t);
		result.accept("Pranith");

		List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6);
		data.forEach(d -> System.out.println(d));
	}

}
