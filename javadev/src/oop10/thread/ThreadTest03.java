package oop10.thread;

public class ThreadTest03 implements Runnable {
	public static void main(String[] args) {
		ThreadTest03 r = new ThreadTest03();
		Thread t = new Thread(r);
		t.start();
		
		for (int i = 1; i <= 5; i++) {
			System.out.println("main : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("run : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
