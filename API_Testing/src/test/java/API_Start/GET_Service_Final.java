package API_Start;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
//import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class GET_Service_Final {
	
		
	@Test
	public void test2() {

		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		
		then().
		statusCode(200).
		and().
		body("data[1].id", equalTo(8)).
		and().
		log().all();
	}
}
