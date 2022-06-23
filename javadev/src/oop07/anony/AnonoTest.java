package oop07.anony;

public class AnonoTest {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.rc.turnOn();
		anony.rc.turnOff();
		anony.method1();
		anony.method2(new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("SmartTV를 켭니다.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("SmartTV를 끕니다.");
			}
		});
	}
}
