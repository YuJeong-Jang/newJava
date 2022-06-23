package basic;

import java.util.Scanner;

public class OpTest01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	//system.in은 콘솔(표준)입력, 즉 키보드 입력을 의미
		
		System.out.print("정수 a값 입력 : ");
		int a = sc.nextInt();
		System.out.print("정수 b값 입력 : ");
		int b = sc.nextInt();
		System.out.println(a + "+" + b + "=" + (a + b));	//앞에서부터 실행되므로 괄호로 묶어줘야 덧셈연산이 됨
		System.out.println(a + "-" + b + "=" + (a - b));	
		System.out.println(a + "*" + b + "=" + (a * b));	
		System.out.println(a + "/" + b + "=" + (a / b));	//정수 나누기 정수는 몫
		System.out.println(a + "%" + b + "=" + (a % b));	//정수 퍼센트 정수는 나머지
		
		sc.close();
	}
}
