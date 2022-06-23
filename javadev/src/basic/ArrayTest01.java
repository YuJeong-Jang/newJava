package basic;

public class ArrayTest01 {
	public static void main(String[] args) {
		int[] arr = new int[3];
		
		arr[0] =100;
		arr[1] =200;
		arr[2] =300;
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
