package oop06.inter02;

public class Pitcher implements BodySign{

	@Override
	public void throwBall(int how) {
		String str = null;
		
		switch(how) {
		case BodySign.CENTER: str = "중앙"; break;
		case BodySign.LEFT: str = "왼"; break;
		case BodySign.RIGHT: str = "오른"; break;
		case BodySign.DOWN: str = "아래"; break;
		case BodySign.UP: str = "위"; break;
		default: str = "잘못된"; break;
		}
	System.out.println(str + "쪽으로 던집니다.");	
	}

}
