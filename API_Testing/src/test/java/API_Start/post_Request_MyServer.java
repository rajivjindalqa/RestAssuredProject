package API_Start;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class post_Request_MyServer {

	@Test
	public void get() {
		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		
		then().
		statusCode(200).
		and().
		body("data[4].first_name", equalTo("George")).
		and().
		body("data.first_name",hasItems("George"));
	}
	
	
	@Test
	public void get_data() {
		baseURI="http://localhost:3000";
		given().
		get("/users").
		
		then().
		statusCode(200).
		and().
		body("[0].name", equalTo("Rajiv"));
	}
	
	
	@Test
	public void post_data() {


		JSONObject jo = new JSONObject();
		jo.put("name", "Reema");
		//jo.put("email", "renu@abc.com");
		
		given().contentType(ContentType.JSON).
		accept(ContentType.JSON).body(jo.toJSONString()).
		when().
		post("http://localhost:3000/users").
		then(). 
		statusCode(201). 
		log().all();
		
		
		
		
	}
	
	
	
	
	
	
	
	@Test
	public void post() {
		
		JSONObject request = new JSONObject();
		request.put("first_name", "Rajiv");
		request.put("email_id", "rajiv.jindal@gmail.com");
				
		baseURI="https://reqres.in/api";
		
		given().
		//header("Content-Type","application/json").
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
