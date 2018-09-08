package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import org.junit.Ignore;
import org.junit.Test;



public class restassuredtesting {
	
	private Response response;
	private RequestSpecification request;

	
	
	@Test
	@Ignore
	public void getpet() {
		request = given().contentType(ContentType.JSON);
		response = request.get("http://10.0.10.10:9966/petclinic/api/pettypes");
		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
		}
	
	@Test
	@Ignore
	public void newpet() {
		
		JSONArray petArray = new JSONArray();

		JSONArray visitArray = new JSONArray();

		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/owners";

		Map<String, Object> emptyOwner = new HashMap<>();

		Map<String, Object> emptyPet = new HashMap<>();

		Map<String, Object> nestedVisitAsMap = new HashMap<>();

		nestedVisitAsMap.put("date", "yyyy/MM/dd");
		nestedVisitAsMap.put("description", "string");
		nestedVisitAsMap.put("id", 0);
		nestedVisitAsMap.put("pet", emptyPet);
		visitArray.add(nestedVisitAsMap);

		Map<String, Object> nestedPetAsMap = new HashMap<>();

		Map<String, Object> nestedTypeAsMap = new HashMap<>();

		nestedTypeAsMap.put("id", 0);

		nestedTypeAsMap.put("name", "String");

		nestedPetAsMap.put("birthDate", "2018-07-27T09:02:40.767Z");
		nestedPetAsMap.put("id", 0);
		nestedPetAsMap.put("name", "String");
		nestedPetAsMap.put("owner", emptyOwner);
		nestedPetAsMap.put("type", nestedTypeAsMap); // needs nested type TODO
		nestedPetAsMap.put("visits", visitArray); // needs nested type TODO

		 petArray.add(nestedPetAsMap);
		JSONObject requestParams = new JSONObject();

		requestParams.put("address", "Manchester");
		requestParams.put("city", "This is a test");
		requestParams.put("firstName", "ANTHIA");
		requestParams.put("id", 10);
		requestParams.put("lastName", "String");
		requestParams.put("pets", petArray);
		requestParams.put("telephone", "1234567891");


		given().contentType(ContentType.JSON).body(requestParams).when().post("/").then().statusCode(201);

		System.out.println(requestParams.toString());​

		
		
	}
	
	@Test
	@Ignore
	public void deletepet() {
		request = given().contentType(ContentType.JSON);
		response = request.delete("http://10.0.10.10:9966/petclinic/api/pettypes/6");
		
		
	}

	@Test
	
	public void updatepet() {
		request = given().contentType(ContentType.JSON);
		JSONObject add = new JSONObject();
		add.put("id", 4);
		add.put("name", "lyle");
		
		request.body(add.toString());
		
		response = request.put("http://10.0.10.10:9966/petclinic/api/pettypes/4");
		response = request.get("http://10.0.10.10:9966/petclinic/api/pettypes/4");
	}
	
	
	
	
	
	
	
	
	
}
