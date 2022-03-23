package API_Start;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class rough_work {

	
	@Test
	public void soapTEst() throws IOException {
		
		File file = new File("./SoapRequest/soap.xml");
		FileInputStream fs = new FileInputStream(file);
		
		String RequestBody = IOUtils.toString(fs, "UTF-8"); 
		
		baseURI="http://www.dneonline.com/";
		given().contentType("text/xml").accept(ContentType.XML).body(RequestBody).
		when(). 
		post("/calculator.asmx").then().statusCode(200).log().all(); 

		
		
		
		
	}
	
	
}
