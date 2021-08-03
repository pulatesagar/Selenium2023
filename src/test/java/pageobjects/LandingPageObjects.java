package pageobjects;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class LandingPageObjects extends Interact {
	
	private static final Logger logger = LogManager.getLogger(LandingPageObjects.class);
	Scenario scn;

	private By btn_loginbutton = By.xpath("//*[@id=\"LoginButton\"]");


	public LandingPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	public void urlValidate()
	{
		boolean status = validateElementIsDisplayed(btn_loginbutton);
		System.out.println(status);
		if(status)
		{
			System.out.println("Login page loaded");
		}
		else
		{
			System.out.println("Login page is NOT loaded");
		}
		assertTrue(status);
	}
	
	public void getPageTitle()
	{
		System.out.println("Page title is : " + getDriver().getTitle());
	}

	
	

}
