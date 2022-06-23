package basic;

public class DoWhileTest02 {
	public static void main(String[] args) {
		int n1, n2;

		n1 = (int) (Math.random() * 6) + 1;
		//n1과 n2가 같지 않았으면 해
		do {
			n2 = (int) (Math.random() * 6) + 1;
		} while (n2 == n1);
		System.out.println(n1 + ", " + n2);
	}
}
