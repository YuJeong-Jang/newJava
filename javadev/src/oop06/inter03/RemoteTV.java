package oop06.inter03;

public abstract class RemoteTV implements RemoteControl{

	@Override
	public void powerOn() {
		System.out.println("RemoteTV 전원을 켭니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("RemoteTV 전원을 끕니다.");
	}

	@Override
	public void channelUp() {
		System.out.println("RemoteTV 채널을 올립니다.");
	}

}
