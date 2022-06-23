package oop05.abstract02;

public class AnimalTest {
	public static void main(String[] args) {
		Animal a = new Dog();
		a.sleep();
		
		Animal c = new Cat();
		c.sleep();
		
		Animal t = new Tiger();
		t.sleep();
	}
}
