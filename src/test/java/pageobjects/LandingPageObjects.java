package pageobjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class LandingPageObjects extends Interact {
	
	private static final Logger logger = LogManager.getLogger(LandingPageObjects.class);
	Scenario scn;

	private By txt_headerLoginLink = By.xpath("//*[@id=\"headerLoginLink\"]/span");


	public LandingPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	public void clickLoginLinks()
	{
       clickElement(txt_headerLoginLink);
	}
	

	
	

}
