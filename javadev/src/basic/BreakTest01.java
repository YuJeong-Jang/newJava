package basic;

public class BreakTest01 {
	public static void main(String[] args) {
		int sum = 0;

		int i = 1;
		while (true) {
			sum += i;
			if (sum >= 100)
				break;	//특정 조건이 되면 while문을 빠져나간다
			i++;
		}
		System.out.println("1부터 " + i + "까지 정수의 합계는 " + sum);
	}
}
