package basic;

public class OpTest09 {
	public static void main(String[] args) {
		double d = 10;	//자동 형변환
		//System.out.println(d);
		
		int i = (int) 3.141592;	//소수점 아래의 데이터가 자동 형변환 되면 데이터가 날라가므로 자동으로 안됨
								//(int)로 캐스트 해주면 소숫점 아래의 데이터가 날라감
		//System.out.println(i);
	}
}
