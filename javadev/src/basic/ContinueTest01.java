package basic;
/*
 * continue
 * 	:반복문 블럭의 마지막으로 !! 혹은 증감식으로 간다
 */
public class ContinueTest01 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 3 != 0) continue; 	//식이 아닐때 컨티뉴 -> 그 후의 과정은 건너뛰고 증감식으로 가버림(3의 배수가 아니면 건너뜀)
				sum += i;
		}
		System.out.println("1부터 10까지 3의 배수의 합계는 " + sum);
	}
}
