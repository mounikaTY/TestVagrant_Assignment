package com.Assignment.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	

	private FileInputStream fis;
	private Properties properties;
	
	public void initializePropertyFile(String propertyFileFath) {
		
		try {
			fis=new FileInputStream(propertyFileFath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	 properties=new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
      
	public String getDataFromPropertyFile(String key) {
		return properties.getProperty(key);
	}




}
