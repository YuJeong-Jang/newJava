package basic;

public class ForTest03 {
	public static void main(String[] args) {
		int n = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i % 3 == 0)
				n += i;
		}
//		for(int i=0; i<=1000; i+=3) {
//			n += i;
//		}	//얘가 반복문 도는 횟수가 적어서 속도는 빠름
		System.out.println(n);
	}
}
