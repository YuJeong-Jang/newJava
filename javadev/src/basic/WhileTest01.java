package basic;

public class WhileTest01 {
	public static void main(String[] args) {
		int i = 1; // while문은 초기식이 밖에 우선선언 되어 있어야함
		
		while (i <= 3) {
			System.out.println("오라클 자바");
			i++;
		}
		System.out.println("종료");
	}
}
