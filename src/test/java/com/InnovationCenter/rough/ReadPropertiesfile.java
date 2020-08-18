package com.InnovationCenter.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesfile {

	
	public static void main(String[] args) throws IOException {
		
		/*
		 * for reading properties file 
		 * create properties instance
		 * create fileInputStream instance to hold the path of properties file 
		 * call load() method of properties instance and pass fis 
		 * then get the values by specifing the key 
		 * 
		 */
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\config.properties");
		prop.load(fis);
		System.out.println(prop.get("baseUri"));
		
	}
}
