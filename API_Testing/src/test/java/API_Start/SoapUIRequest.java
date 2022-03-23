package API_Start;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class SoapUIRequest {
	
	
	@Test
	public void soapTest() throws IOException{
		
	File file = new File("./SoapRequest/soap.xml");	
	FileInputStream fs = new FileInputStream(file);
	
	String requestBody = IOUtils.toString(fs, "UTF-8");     //common-io dependency required for this 
		
    baseURI="http://www.dneonline.com";
    given().contentType("text/xml").accept(ContentType.XML). 
    body(requestBody).when().
    post("/calculator.asmx").then().statusCode(200). 
    body("//*:AddResult.text()", equalTo("5"))
    .log().all();
		
		
	}

}
