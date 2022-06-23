package oop06.inter02;

public class BodySignTest {
	public static void main(String[] args) {
		BodySign bs = new Pitcher();
		bs.throwBall(BodySign.CENTER);
		bs.throwBall(1);
	}
}
