package oop02.static03;

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person("김연아", "korean");
		Person p2 = new Person("김연경", "korean");
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("===============================================");
		
		p1.setName("연느");
		p1.setNation("angel");
		System.out.println(p1);
		System.out.println(p2);
	}
}
