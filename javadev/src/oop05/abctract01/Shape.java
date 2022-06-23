package oop05.abctract01;

//클래스 안에 추상메소드가 하나라도 포함이 되면 클래스 자체를 추상클래스로 변경해줘야 한다 => abstract 추가
public abstract class Shape {
	double res;

	// 추상메소드
	public abstract void area();

//	추상클래스를 상속받는 하위 클래스는 반드시 추상 메소드를 강제로 오버라이딩해야 한다.(이름동일)
}
