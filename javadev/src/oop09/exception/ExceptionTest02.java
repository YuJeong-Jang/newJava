package oop09.exception;

public class ExceptionTest02 {
	public static void main(String[] args) {
		throwException();
		
		System.out.println("종료");
	}

	private static void throwException() {
		System.out.println("throwException 메서드 수행 시작");
		
		try {
			throw new Exception("사용자가 강제 예외 발생");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("throwException 메서드 수행 완료");
	}
}
