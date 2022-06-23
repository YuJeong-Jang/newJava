package basic;

public class OpTest04 {
	public static void main(String[] args) {
		int a = 5;
		//++a;	//a = a + 1; (prefix)
		System.out.println("a : " + a);
		
		//a++;	//a = a + 1; (postfix)
		int b = ++a;	//a = a + 1;
						//b=a;
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	}
}
