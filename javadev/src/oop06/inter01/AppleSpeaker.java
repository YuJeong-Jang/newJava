package oop06.inter01;

public class AppleSpeaker implements Speaker{

	@Override
	public void soundUp() {
		System.out.println("AppleSpeaker : 볼륨을 키웁니다.");
	}

	@Override
	public void soundDown() {
		System.out.println("AppleSpeaker : 볼륨을 줄입니다.");
	}
	
}
