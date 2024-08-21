package com.castcast.crm.generic.fileutlity;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {

	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		
		String path = "./test_config/jsontestdata.json";
	
		FileReader reader=new FileReader(path);
		
		JSONParser pars=new JSONParser();
		
		Object object = pars.parse(reader);
		
		JSONObject obj=(JSONObject) object; //converting into key and value pair
		
		String data = (String) obj.get(key);
		
		return data;
		
	}
	
}
