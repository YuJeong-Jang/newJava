package oop02.static02;

public class NPTest {
	public static void main(String[] args) {
//		NumberPrinter np = new NumberPrinter();
//		np.showInt(10);
		
		NumberPrinter.showInt(10);		//static이면 객체 만들지 말고 불러와도 불러짐
		NumberPrinter.showDouble(3.14645);	
		
	}
}
