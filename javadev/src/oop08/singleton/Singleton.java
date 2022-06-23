package oop08.singleton;

public class Singleton {
//	2. 자기자신을 참조할 수 있는 변수를 선언 후, private static 지정
	private static Singleton singleton = null;
	
//	1. 생성자를 작성하고, private으로 설정
	private Singleton() {
		//반환형이 없는 기본 생성자
	}
	
//	3. 자기자신의 인스턴스를 반환하는 게터 메소드 작성
	public static Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}
