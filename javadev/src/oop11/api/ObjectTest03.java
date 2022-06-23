package oop11.api;

public class ObjectTest03 {
	public static void main(String[] args) {
		String str1 = new String("실수란 신을 용서하는 인간의 행위이다.");
		String str2 = new String("실수란 신을 용서하는 인간의 행위이다.");

//		new 연산자에 의해 같은 문자열을 가지고 있어도 새로 공간을 만드므로 서로 다른 객체를 참조해서 다르게 인식함
		if (str1 == str2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

		if (str1.equals(str2)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		System.out.println(str1);
		System.out.println(str1.hashCode());
		System.out.println(str1 = str1.replace("실수란", "성형은"));
		System.out.println(str1.hashCode());
	}
}
