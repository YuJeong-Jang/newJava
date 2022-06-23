package oop01;

public class Point3D extends Point2D {
	private int z;

	public Point3D() {
		this(10,20,30);
//		System.out.println("Point3D() 수행중");
//		super();
//		//하위클래스(자식)의 생성자(Point3D)에서는 반드시 상위클래스(부모)의 생성자(super)를 호출하게 되어있다
	}

	public Point3D(int x, int y, int z) {
		super(x,y);
//		this.setX(x);	//따로 쓰는거보단 super로 정의해주는게 깔끔
//		this.setY(y);
		this.z = z;
//		System.out.println("Point3D(x,y,z) 수행중");
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public void print() {
		super.print();
//		this.z = 30;
		System.out.println("z = " + getZ());
	}
}
