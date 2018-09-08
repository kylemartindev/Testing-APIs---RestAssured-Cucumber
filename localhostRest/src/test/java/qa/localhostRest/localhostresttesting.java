package qa.localhostRest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;





import io.restassured.RestAssured;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.json.JSONObject;




public class localhostresttesting {

	private RequestSpecification request;
	private Response response;
	
	
	
	@Test
	@Ignore
	public void putdata() {
		
		
		
		
		RestAssured.baseURI = ("http://localhost:8090/example/v1/hotels");
		
		RequestSpecification request = given().contentType(ContentType.JSON);	
		
	
		
		JSONObject addata = new JSONObject();
		
		
		
		addata.put("city","Liverpool");
		addata.put("description","smoky");
		addata.put("id", 5);
		addata.put("name","Peter");
		addata.put("rating",5); 
		
		System.out.println(addata);
		
		request.body(addata.toString());
		
		Response response = request.post("http://localhost:8090/example/v1/hotels/");		
	
		System.out.println(response.getStatusCode());
		
		//assertEquals(201, response.getStatusCode());
		
	}
	@Test
	@Ignore
	public void deletedata() {
		request = given().contentType(ContentType.JSON);	
		response = request.delete("http://localhost:8090/example/v1/hotels/3");	
	}
		
	@Test
	
	public void updatedata() {
		
		request = given().contentType(ContentType.JSON);
		JSONObject changedata = new JSONObject();
		
		
		changedata.put("city", "London");
		changedata.put("description", "Large");
		changedata.put("id", 5);
		changedata.put("name", "John");
		changedata.put("rating",10);
		
		
		request.body(changedata.toString());
		response = request.put("http://localhost:8090/example/v1/hotels/5");
		response = request.get("http://localhost:8090/example/v1/hotels/5");
		
		
		
		System.out.println("response:" + response.prettyPrint());
		
		System.out.println(response.getStatusCode());
		
		
	}









}
