package stepdefs;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.manager.driver.factory.DriverFactory;
import utils.manager.driver.factory.DriverManager;

public class LandingStepDefs extends TestBase {
	TestContextUI testContextUI;
	Scenario scn;

	public LandingStepDefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	
	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}

	
	@After
	public void CleanUp(Scenario s) {
		
		if (s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot)testContextUI.getDriver();
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
		}
		
		testContextUI.getDriver().quit();
		scn.write("Browser is Closed");
	}
	
	
	@Given("browser is open")
	public void browser_is_open() throws Exception {
		/* Various ways of invoking Web Driver*/
		/* Mehtod - 1*/
		
		
		DriverManager driverManager = DriverFactory.getDriverManager("chrome");
		WebDriver driver = driverManager.getDriver();
		driverManager.maximizeBrowser();
		driverManager.navigateToDriver(server_ui);
		
		/* OR Mehtod - 2*/
		/*
		 *WebDriver driver = new ChromeDriver();
		 *driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		 *driver.manage().window().maximize();
		 *driver.get(serverUI);
		*/
		

		/* OR Mehtod - 3*/
		/*
		 WebDriver driver = WebDriverManagerSingleton.getInstanceOfWebDriverManager().getDriver();
		*/
		
		/* OR Mehtod - 4*/
		/*
		WebDriver driver = WebDriverManagerSimple.getDriver("chrome");
		*/
		scn.write("Chrome Driver invoked and URL navigated as: " + server_ui);
		//Assign driver and set page Objects to Test Context 
		testContextUI.setDriver(driver);
		testContextUI.initializePageObjectClasses(driver, scn);
	}

	/*@When("user clicks on login link")
	public void user_clicks_on_login_link() {
		//testContextUI.landingPageObjects().clickLoginLinks();
	}*/

	@And("user should be redirected to the login page")
	public void user_should_be_redirected_to_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	
		testContextUI.landingPageObjects().urlValidate();
		testContextUI.landingPageObjects().getPageTitle();
	
	
	}



}
