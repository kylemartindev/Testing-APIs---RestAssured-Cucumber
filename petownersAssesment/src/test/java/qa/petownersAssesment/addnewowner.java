package qa.petownersAssesment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addnewowner {
	
	
	@FindBy (name="firstName")
	private WebElement firstname;
	
	@FindBy (name="lastName")
	private WebElement lastname;
	
	@FindBy (name="address")
	private WebElement address;
	
	@FindBy (name="city")
	private WebElement city;
	
	@FindBy (name="telephone")
	private WebElement telephone;
	
	@FindBy (xpath="/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")
	private WebElement click;
	
	
	public void addetails() {
		
		firstname.sendKeys("Bobby");
		firstname.sendKeys(Keys.TAB);
		lastname.sendKeys("brown");
		lastname.sendKeys(Keys.TAB);
		address.sendKeys("Maple Avenue");
		address.sendKeys(Keys.TAB);
		city.sendKeys("Manchester");
		city.sendKeys(Keys.TAB);
		telephone.sendKeys("0175758224");
		click.click();
		
	}
	
	
	

}
