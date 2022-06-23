package oop11.api;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ApiTest01 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("신혜선");
		set.add("박보영");
		set.add("신혜선");
		set.add("서현진");
		set.add("김고은");
	
		System.out.println(set.size());
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
