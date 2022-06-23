package oop05.abstract02;

public class Tiger extends Animal{
	public void attack() {
		System.out.println("사자가 공격을 합니다.");
	}

	@Override
	public void sleep() {
		System.out.println("사자가 눈뜨고 잠을 잡니다.");
	}
}
