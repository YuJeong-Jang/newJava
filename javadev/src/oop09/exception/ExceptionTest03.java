package oop09.exception;

public class ExceptionTest03 {
	public static void main(String[] args) {
		try {
			throwException();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("종료");
	}

	private static void throwException() throws Exception {
		System.out.println("throwException 메서드 수행 시작");
		throw new Exception("사용자가 강제 예외 발생");

	}
}
