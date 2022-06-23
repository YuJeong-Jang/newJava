package basic;

public class DataType {
	public static void main(String[] args) {
		boolean b1 = false;
		System.out.println("b1 : " + b1);

		// char c = 'A';
		char c = 54620;
		System.out.println("c : " + c);

		byte b2 = 127;
		System.out.println("b2 " + b2);

		short s = 32767;
		System.out.println("s : " + s);

		int i = 2147483647;
		System.out.println("i : " + i);

		long l1 = 2147483648L; // 자바는 숫자를 무조건 int로 인식함. 그래서 뒤에 L을 붙여줘야 long 타입으로 인식
		System.out.println("l1 : " + l1);

		double d = 3.1415926535;
		System.out.println("d : " + d);

		float f = 3.1415926535F; // 소수점을 가지고 있는 데이터는 무조건 double 타입으로 인식하므로 뒤에 F를 붙여 float으로 인식시킴
		System.out.println("f : " + f); // 같은 소수점 데이터를 입력해도 정밀도가 떨어짐
		
		//escape sequence
		System.out.println("그가 말했다. \"안녕하세요~!\"");
		System.out.println("안녕하세요\n반갑습니다");
		System.out.println("0\t1\t2\t3\t4");
	}
}
