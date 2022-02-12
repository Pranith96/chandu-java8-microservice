import java.util.function.Predicate;

public class PredicateExample1 implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {

		if (t % 2 == 0) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		Predicate<Integer> result = new PredicateExample1();
		System.out.println(result.test(4));

		Predicate<Integer> result1 = t -> t % 2 == 0;
		System.out.println(result1.test(6));
	}
}
