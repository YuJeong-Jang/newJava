package oop02.static01;

public class AccountTest {
	public static void main(String[] args) {
		System.out.println(Account.money1);
		
		Account acc1 = new Account(10000);
		System.out.println("acc1.money1 : " + acc1.money1);
		System.out.println("acc1.money2 : " + acc1.money2);
		
		Account acc2 = new Account(20000);
		System.out.println("acc2.money1 : " + acc2.money1);
		System.out.println("acc2.money2 : " + acc2.money2);
		
		Account acc3 = new Account(30000);
		System.out.println("acc3.money1 : " + acc3.money1);
		System.out.println("acc3.money2 : " + acc3.money2);
	}
}
