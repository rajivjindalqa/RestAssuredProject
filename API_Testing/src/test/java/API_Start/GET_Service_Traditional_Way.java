package API_Start;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_Service_Traditional_Way {
	
	@Test
	public void api_test() {
	
		Response rs = RestAssured.get("https://reqres.in/api/users?page=2"); 
		
		System.out.println(rs.getStatusCode());
		System.out.println(rs.getTime());
		System.out.println(rs.getBody().asString());
		System.out.println(rs.getStatusLine());
		System.out.println(rs.getHeader("content-type"));
		
		//Add assertions
		
		Assert.assertEquals(rs.getStatusCode(), 200);
	}


}
