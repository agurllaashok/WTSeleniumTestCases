package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonData {
			static String s;
			public static String passingData(String text){
		    	JSONParser parser = new JSONParser();
		    	JSONObject jsonObject=new JSONObject();
		        try {
		        	Object object = parser.parse(new FileReader("C:\\Users\\smsc\\eclipse-workspace\\WT\\src\\main\\java\\utils\\TestData.json"));
			    	jsonObject = (JSONObject)object;
			    	s=(String)jsonObject.get(text);						
		        } 
		        catch (FileNotFoundException e) {
		            e.printStackTrace();
		        }
		        catch(Exception e)
		        {
		            e.printStackTrace();
		        }
				return s;
		}
}