package oop11.api;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;

public class ApiTest04 {
	public static void main(String[] args) {
		Properties pr = new Properties();
		FileInputStream f = null;

		try {
			f = new FileInputStream("test.properties");
			pr.load(f);
			Iterator keyiter = pr.keySet().iterator();
			while (keyiter.hasNext()) {
				String key = (String) keyiter.next();
				System.out.println(key + ":" + pr.getProperty(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (Exception e) {
				}
		}
	}
}
