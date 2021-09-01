package context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pageobjects.*;

public class TestContextUI {

	private WebDriver driver;
	private LandingPageObjects landingPageObjects;
	private LoginPageObjects loginPageObjects;


	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPageObjects landingPageObjects() {
		return landingPageObjects;
	}
	
	public LoginPageObjects loginPageObjects() {
		return loginPageObjects;
	}

	public void initializePageObjectClasses(WebDriver driver,Scenario scn) {
		landingPageObjects = new LandingPageObjects(driver,scn);
		loginPageObjects = new LoginPageObjects(driver,scn);


	}
	
}
