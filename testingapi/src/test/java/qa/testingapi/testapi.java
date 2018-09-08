package qa.testingapi;





import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;


public class testapi {
	
	private Response response;
	private RequestSpecification request;
	private ValidatableResponse json;
	
	@Given("^a film exists with the Title Guardians of the Galaxy Two$")
	public void a_film_exists_with_the_Title_Guardians_of_the_Galaxy_Two() {
		request = given().contentType(ContentType.JSON);
		
	}
	
	@When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
	public void a_user_retrieves_the_film_by_the_title_Guardians_of_the_Galaxy_Two() {
		
		response = request.when().get("http://www.omdbapi.com/?i=tt3896198&apikey=67918294");
		
	}
	
	
	@Given("^a film exists with the Title IT$")
	public void a_film_exists_with_the_Title_IT() {
		
		request = given().contentType(ContentType.JSON);
		
	}
	
	@When("^a user retrieves the film by the title IT$")
	public void a_user_retrieves_the_film_by_the_title_IT() {
		
		response = request.when().get(" http://www.omdbapi.com/?i=tt3896198&apikey=67918294");
	}
	
	@Then("^the status code reads 200$")
	public void the_status_code_reads_200() {
		json = response.then().statusCode(200);
	}
	
	@And("^the Rated Field is equal to R$")
	public void the_Rated_Field_is_equal_to_R() {
		expect().body("Rated", equalTo("R"));
		
	}

	@Given("^a film exists with the Title \"([^\"]*)\"$")
	public void a_film_exists_with_the_Title(String arg1) {
	
		request = given().contentType(ContentType.JSON);
		
	}
	
	
	@When("^a user retrieves the film by the title \"([^\"]*)\"$")
	public void a_user_retrieves_the_film_by_the_title(String arg1) {
		
		response = request.when().get(" http://www.omdbapi.com/?i=tt3896198&apikey=67918294&" + arg1);
		
	}
	
	@And("^the Rated Field is equal to PG$")
	public void the_Rated_Field_is_equal_to_PG() {
		expect().body("Rated", equalTo("PG"));
}
	
	@Given("^a film exists with the Title \"<title>\"$")
	public <title> void a_film_exists_with_the_Title_(String arg1) {
		request = given().contentType(ContentType.JSON);
		
	}
	
	@When("^a user retrieves the film by the title \"<title>\"$ ")
	public void a_user_retrieves_the_film_by_the_title_(String arg1) {
		
		response = request.when().get(" http://www.omdbapi.com/?i=tt3896198&apikey=67918294&" + arg1);
	
	}
	
	@Then("^the Rated Field is equal to \"([^\"]*)\"$")
	public void  the_Rated_Field_is_equal_to(String arg1) {
		expect().body("Rated", equalTo(arg1));
		
		
	}
}
