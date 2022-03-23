package API_Start;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class getAndPost {

	
	
	@Test
	public void getTest() {
		
		baseURI ="http://localhost:3000";
		given().when().
		get("/resources"). 
		then(). 
		statusCode(200).
		body("[1].name", equalTo("Himanshu")).
		body("name", hasItems("Chitra", "Rajiv")). 
		log().all();
	
		JSONObject request = new JSONObject();
		request.put("name", "Sai");
		request.put("email", "sai@abc.com");
		
		given().
		contentType(ContentType.JSON). 
		accept(ContentType.JSON).body(request.toJSONString()).
		post("/resources").
		then().
		statusCode(201).
		log().all();
		
		
		
	}
	
	
	
	
	
	@Test
	public void putTest() {
		
		baseURI ="http://localhost:3000";
		
		when().
		delete("/resources/1").
		then().
		//statusCode(200).
		log().all();
		
	}
	
	

}
