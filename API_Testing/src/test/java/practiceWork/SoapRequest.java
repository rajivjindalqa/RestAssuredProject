package practiceWork;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class SoapRequest {

	@Test
	public void soap() throws IOException {
		
		File file = new File("./SoapRequest/soapRequest.xml");  //input xml request path
		FileInputStream fs = new FileInputStream(file); 
		String SoapRequest = IOUtils.toString(fs,"UTF-8"); //encoding the file
		
		baseURI="http://www.dneonline.com/";
		given().
			contentType("text/xml"). //content we are sending is xml type
			accept(ContentType.XML). //content should be returned in xml format
			body(SoapRequest).  //passing the encoded soap request in body
		when().
			post("/calculator.asmx").  //posting the request
		then().
		statusCode(200).  //should give a success message
		assertThat().body("//AddResult.text()", equalTo("11")).  //verify the specific attribute value in output
		and(). 
		body(matchesXsdInClasspath("xmlSchema.xsd")). // validate the schema
		log().all(); //log everything i.e. show all in console/output result.
		
		
		
	}
	
}
