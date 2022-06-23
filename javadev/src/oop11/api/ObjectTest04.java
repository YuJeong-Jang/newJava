package oop11.api;

public class ObjectTest04 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		printString(sb);
		
		sb.append("실수란 ");
		printString(sb);
		sb.append("신을 용서하는 ");
		printString(sb);
		sb.append("인간의 행위이다.");
		printString(sb);
		sb.insert(16, "자비로운 ");
		printString(sb);
		sb.delete(16, 21);
		printString(sb);
		sb.reverse();
		printString(sb);
		sb.reverse();
		printString(sb);
	}

	private static void printString(StringBuilder sb) {
		System.out.println(sb.length() + ":" + sb.capacity());
		System.out.println(sb);
	}
}
