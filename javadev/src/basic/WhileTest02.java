package basic;

public class WhileTest02 {
	public static void main(String[] args) {
		int n = 0;
		int i = 1;
		while ( i <= 1000 ) {
			if (i % 3 == 0)
				n += i;
			i++;
		}
		System.out.println(n);
	}
}
