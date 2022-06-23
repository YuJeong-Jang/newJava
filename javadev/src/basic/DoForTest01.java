package basic;

public class DoForTest01 {
	public static void main(String[] args) {
		int n = 0;
		int i = 1;
		do {
			if (i % 3 == 0)
				n += i;
			i++;
		} while (i <= 1000);
		System.out.println(n);
	}
}
