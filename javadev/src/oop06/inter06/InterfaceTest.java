package oop06.inter06;

public class InterfaceTest {
	public static void main(String[] args) {
		InterImpl impl = new InterImpl();
		InterfaceA ia = impl;
		InterfaceB ib = impl;
		InterfaceC ic = impl;

		ia.methodA();
		impl.methodA();
		
		ib.methodB();
		impl.methodB();
		
		ic.methodC();
		impl.methodC();
	}
}
