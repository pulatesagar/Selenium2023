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

	@When("I navigate to url {string}")
	public void i_navigate_to_url(String string) {
		testContextUI.landingPageObjects().navigateUrl(string);
	}

	@And("Search for {string} in the search bar")
	public void search_for_in_the_search_bar(String string) {
		testContextUI.landingPageObjects().searchProducts(string);

	}

	@And("Save the URL of Headphones")
	public void save_the_URL_of_Headphones() {
		testContextUI.landingPageObjects().saveProductUrl();
    
	}

	@Then("Open a new tab")
	public void open_a_new_tab() {
		testContextUI.landingPageObjects().openNewTab();
	}
	@When("Click on demo button")
	public void click_on_demo_button() throws InterruptedException {
		testContextUI.landingPageObjects().clickOnClickMeDemo();
	}

	@Then("Select OK option")
	public void select_OK_option() throws InterruptedException {
		testContextUI.landingPageObjects().acceptOK();
		testContextUI.landingPageObjects().cancelButton();
	}
	@And("I click on New Window button")
	public void i_click_on_New_Window_button() throws InterruptedException {
		testContextUI.landingPageObjects().childWindowHandle();
	}
	@And("I switch to frame")
	public void i_switch_to_frame() throws InterruptedException {
		//testContextUI.landingPageObjects().iframeTestJavaScript();
		
	}





}
