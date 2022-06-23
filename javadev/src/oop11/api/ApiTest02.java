package oop11.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApiTest02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("신혜선");
		list.add("박보영");
		list.add("신혜선");
		list.add("서현진");
		list.add("김고은");
	
		System.out.println(list.size());
		
//		Iterator<String> iter = list.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
	
		for(String str : list) {
			System.out.println(str);
		}
	}
}
