package API_Start;



import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;
public class JsonschemaValidator {

		@Test
		public void get() {
			baseURI="https://reqres.in/api";
			given().
			get("/users?page=2").
			
			then().
			statusCode(200).
			and(). 
			assertThat(). 
			body(matchesJsonSchemaInClasspath("schema.json"));
		}
}
