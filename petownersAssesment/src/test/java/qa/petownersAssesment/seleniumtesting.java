package qa.petownersAssesment;


import org.junit.After;



import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class seleniumtesting {
	ExtentReports report;
	ExtentTest test; 
	WebDriver driver;
	String web;
	
	
	@Before
	public void setup() {
		report = new ExtentReports("C:\\Windows\\Users\\Admin\\Documents\\reports.html");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe"); 
 		driver = new ChromeDriver(); 
 		driver.manage().window().maximize();
 		test = report.startTest("Website");
 		
 	}

	@Given("^I access the website$")
	
	public void I_access_the_website() {
		
		driver.get("http://10.0.10.10:4200/petclinic/welcome");
		
	}
	
	@When("^I click add new owner$")
	public void I_click_add_new_owner() {
		links link = PageFactory.initElements(driver, links.class);
		link.newownerclick(driver);

	}
	
	@Then("^new owner page is opened$")
	public void new_owner_page_is_opened() {
		
		
		assertEquals("http://10.0.10.10:4200/petclinic/owners/add",driver.getCurrentUrl());
		//test.log(LogStatus.PASS, "New Owner page is opened");
	}
	
	@And ("^new owner details are entered$")
	public void new_owner_details_are_entered() {
		addnewowner add = PageFactory.initElements(driver, addnewowner.class);
		add.addetails();
		
	}
	
	@Then("^new owner is added successfully$")
	public void new_owner_is_added_sucessfully() {
		assertEquals("",driver.findElement(By.xpath("")).getText());
		test.log(LogStatus.PASS, "New owner is added successfully");
	}


	
	
	@After
	public void shutdown() throws InterruptedException {
		Thread.sleep(2000);
		report.flush();
		driver.quit(); 
		
		
	}
	

}
