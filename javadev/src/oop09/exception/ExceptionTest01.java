package oop09.exception;

public class ExceptionTest01 {
	public static void main(String[] args) {
		String str = null;
		try {
			System.out.println(str.toString());
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace(); // 예외가 발생해서 전달되는 과정 출력
			//상위클래스 예외는 위에, 하위클래스 예외는 아래에 위치해야함.
		} finally {
			//예외발생의 유무와 상관없이 무조건 거쳐가는 블럭
			System.out.println("finally 블럭");
		}
		System.out.println("종료");
	}
}
