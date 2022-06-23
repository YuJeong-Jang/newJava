package oop02.static01;

public class Account {
	//static으로 설정하면 특정개체의 고유성질이 사라짐(공유됨)
	static int money1;
	int money2;
	
	public Account(int money) {
		money1 += money;
		money2 += money;
		
	}
	
	
	
	
}
