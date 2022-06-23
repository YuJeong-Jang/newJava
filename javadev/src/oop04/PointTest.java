package oop04;

public class PointTest {
	public static void main(String[] args) {
		//up casting (point3D객체를 point2D로 인식 : x y z가 아닌 x y만 인식)
		Point2D up = new Point3D();
		up.x = 100;
		up.y = 200;
//		up.z = 300;	//컴파일러는 point3d를 point2d로 인식하므로 z를 접근하지 못함
		
		//down casting
		Point3D dn = (Point3D) up; // -> z에 접근할 수 있게됨
		dn.x = 1000;
		dn.y = 2000;
		dn.z = 3000;	//point3d를 정상적으로 모두 인식하므로 이제 z에 접근가능
	}
}
