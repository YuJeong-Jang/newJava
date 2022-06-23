package oop02.static03;

public class Person {
	private String name;
	private String nation;

	public Person(String name, String nation) {
		super();
		this.name = name;
		this.nation = nation;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	@Override
	public String toString() {
		return "person [name=" + name + ", nation=" + nation + "]";
	}
	
	
}
