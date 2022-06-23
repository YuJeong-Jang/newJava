package oop01;

public class Point2D {
	private int x;
	private int y;
	
	public Point2D() {
		this(10,20);
//		System.out.println("Point2D() 수행중");
	}
	//생성자를 만들었다가 지우면 그후에는 컴파일러가 자동으로 생성해주지 않는다.
	
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
//		System.out.println("Point2D(x,y) 수행중");
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;		//this.x는 광역 x변수를 지칭함(메서드 밖에 있는 변수)
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void print() {
		System.out.println("x = " + getX());
		System.out.println("y = " + getY());
	}
	
	
}
