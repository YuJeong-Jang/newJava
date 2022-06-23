package oop06.inter05;

public class FlyingCar implements Drivable, Flyable{

	@Override
	public void fly() {
		System.out.println("하늘을 납니다.");
	}

	@Override
	public void drive() {
		System.out.println("운전합니다.");
	}

}
