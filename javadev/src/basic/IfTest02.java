package basic;

import java.util.Scanner;

public class IfTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("0~100 사이 점수 입력 : ");
		int score = sc.nextInt();

		if (score >= 90) {
			System.out.println("A");
		} else if (80 <= score && score < 90) {
			System.out.println("B");
		} else if (70 <= score && score < 80) {
			System.out.println("C");
		} else if (60 <= score && score < 70) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}

		sc.close();
	}
}
