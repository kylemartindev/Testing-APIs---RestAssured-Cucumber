package qa.petownersAssesment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class links {
	
	@FindBy (xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	private WebElement owners;
	
	@FindBy (xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a/span[2]")
	private WebElement addnew;

	public void newownerclick(WebDriver driver) {
		Actions act = new Actions(driver);
		owners.click();
		
		act.moveToElement(addnew).click().perform();
		
		
	}

}
