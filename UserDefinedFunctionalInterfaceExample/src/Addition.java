@FunctionalInterface
public interface Addition {
	public void add(int a, int b);
	
	public static void sum() {
		System.out.println("Sum");
	}
}
