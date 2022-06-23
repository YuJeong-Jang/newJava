package oop05.abctract01;

public class ShapeTest {
	public static void main(String[] args) {
		printArea(new Circle());
		printArea(new Rectangle());
		printArea(new Triangle());
	}

//	 instanceof 연산자 : 참조변수가 참조하는 인스턴스의 타입을 검사
//	 	1) 매개변수의 타입을 부모 타입으로 선언
//		2) instanceof 연산자를 사용해 타입을 검사
//		3) 타입 변경 후 차별적인 작업 수행

	private static void printArea(Shape s) {
		// circle, rectangle, triangle 모두 shape을 상속하므로 shape을 받아오면 나머지는 자동으로 불러와진다 =>
		// 다형성
		s.area();
		// shape을 통해서 3개의 객체를 가져오긴 햇으나 어떤것을 사용할지 지정해줘야 하므로
		if (s instanceof Circle) {
			Circle c = (Circle) s;
			System.out.println("반지름이 " + c.r + "인 원의 넓이는 " + c.res);
		} else if (s instanceof Rectangle) {
			Rectangle r = (Rectangle) s;
			System.out.println("가로가 " + r.w + ", 세로가 " + r.h + "인 사각형의 넓이는 " + r.res);
		} else if (s instanceof Triangle) {
			Triangle t = (Triangle) s;
			System.out.println("밑변이 " + t.w + ", 높이가 " + t.h + "인 삼각형의 넓이는 " + t.res);
		}
	}
//
//	private static void printArea(Triangle t) {
//		t.area();
//		System.out.println("밑변이 " + t.w + ", 높이가 " + t.h + "인 삼각형의 넓이는 " + t.res);
//	}
//
//	private static void printArea(Rectangle r) {
//		r.area();
//		System.out.println("가로가 " + r.w + ", 세로가 " + r.h + "인 사각형의 넓이는 " + r.res);
//	}
//
//	private static void printArea(Circle c) {
//		c.area();
//		System.out.println("반지름이 " + c.r + "인 원의 넓이는 " + c.res);
//	}

}
