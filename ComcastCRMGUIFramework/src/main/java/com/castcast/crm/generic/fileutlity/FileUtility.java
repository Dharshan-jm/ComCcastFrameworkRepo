package com.castcast.crm.generic.fileutlity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromPropertiesFile(String key) throws IOException {
		
		String path = "./test_config/test_config.properties";
		
		FileInputStream fis=new FileInputStream(new File(path));
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String data = prop.getProperty(key);
		
		return data;
	}

}
