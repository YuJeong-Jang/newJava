package oop06.inter03;

public class RemoteTest {
	public static void main(String[] args) {
		RemoteTV tv = new LgRemoteTV();
		tv.powerOn();
		tv.channelUp();
		tv.channelDown();
		tv.powerOff();
	}
}
