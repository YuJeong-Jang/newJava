package oop05.abstract02;

public class Cat extends Animal{
	public void jump() {
		System.out.println("고양이가 점프를 합니다.");
	}

	@Override
	public void sleep() {
		System.out.println("고양이가 시끄럽게 잠을 잡니다.");
	}
}
