package API_Start;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class post_Request {

	@Test
	public void get() {
		baseURI="http://localhost:3000";
		given().
		get("/users").
		
		then().
		statusCode(200).
		and().
		body("[0].name", equalTo("Rajiv")).
		body("name", hasItems("Rajiv","Geetu"));
	}
	
	@Test
	public void post() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Aaradhya");
				
		baseURI="http://localhost:3000";
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when(). 
		post("/users").
		then(). 
		statusCode(201).
		log().all(); 
	
	}
}
