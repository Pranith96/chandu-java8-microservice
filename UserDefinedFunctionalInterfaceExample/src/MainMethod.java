
public class MainMethod {

	public static void main(String[] args) {
		Addition a = new Addition() {
			public void add(int a, int b) {
				int c = a + b;
				System.out.println(c);
			}
		};
		a.add(5, 5);
		
		Addition ad = (d,e) -> System.out.println(d+e);
		ad.add(10, 10);
		Addition.sum();
	}
}
