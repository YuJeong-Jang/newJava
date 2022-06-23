package oop06.inter07;

public interface MyInterface {
	public void myMethod1();
	
	default void myMethod2() {
		System.out.println("default 메소드인 myMethod2() 수행");
	}
}
