package automations;

import org.apache.hc.core5.util.Asserts;
import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIAutomation {
	
	public static void main(String args[])
	{
		
		// API CALL : api.openweathermap.org/data/2.5/weather?q={city name},{state code}&appid={API key}

		
		 RestAssured.baseURI ="http://api.openweathermap.org/data/2.5/"; 
		 RequestSpecification request = RestAssured.given();
		 
		 Response response = request.queryParam("q", "London,UK") 
		                    .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8") 
		                    .get("/weather");
		 
		 
		 String jsonString = response.asString();
		 System.out.println(jsonString);
		 System.out.println(response.getStatusCode()); 
		 Assert.assertEquals(response.getStatusCode(), 200);
		 Assert.assertEquals(jsonString.contains("London"), true);
				
	}

}
