package day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class PropertiesFileDemo {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		
		Properties pr = new Properties();
		pr.load(fi);
		
		String url = pr.getProperty("appurl");
		
		System.out.println(url);
		
		//select all keys
		
		
		Set<String> keys= pr.stringPropertyNames();
		Set<Object> key2 = pr.keySet();
		
		// select all values
		
		Collection<Object> val = pr.values();
	}

}
