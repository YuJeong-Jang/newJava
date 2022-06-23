package basic;

import java.util.Scanner;

public class OpTest10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("난수 발생1 : " + ((int) (Math.random() * 12) + 4));

		System.out.println("난수 발생2 : " + ((int) (Math.random() * 18) + 6) * 100);
	}
}
