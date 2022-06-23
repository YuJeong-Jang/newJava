package oop10.thread;

public class ThreadTest01 {
	public static void main(String[] args) {
		run();
		for (int i = 1; i <= 5; i++) {
			System.out.println("main : " + i);
			try {
				Thread.sleep(1000); // 밀리세컨드단위 이므로 1000이 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("run : " + i);
			try {
				Thread.sleep(1000); // 밀리세컨드단위 이므로 1000이 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
