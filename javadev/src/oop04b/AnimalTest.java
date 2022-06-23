package oop04b;

public class AnimalTest {
	public static void main(String[] args) {
		Animal a = new Dog();
		a.eat();
		a.sleep();
//		a.bark();
		
		Dog d = (Dog) a;
		d.eat();
		d.sleep();
		d.bark();
	}
}
