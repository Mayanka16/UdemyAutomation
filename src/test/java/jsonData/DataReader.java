package jsonData;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;


import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	//added under BaseTest class for general methods

	//public List<HashMap<String, String>> getJsonDataToHashMap() throws IOException {
		// reading json to string
		// FileUtils.readFileToString(new
		// File("//Users//mayanka//eclipse-workspace//UdemyAutomation//src//test//java//jsonData//PurchaseCloth.json"));
		
		
		
		/*String jsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "//src//test//java//jsonData//PurchaseCloth.json"), StandardCharsets.UTF_8);
		
		//String to HashMap using Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
			
			
		});
		return data;
	}*/

}
