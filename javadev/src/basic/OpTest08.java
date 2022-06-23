package basic;

import java.util.Scanner;

public class OpTest08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		
		int n = sc.nextInt();
		System.out.println((n%2) == 0 ? "짝수" : (n%2) != 0 ? "홀수" : "에러입니다.");
		
		sc.close();
	}
}
