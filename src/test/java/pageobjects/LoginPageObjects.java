package pageobjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ui.Interact;
import cucumber.api.Scenario;



public class LoginPageObjects extends Interact {
	
	private static final Logger logger = LogManager.getLogger(LoginPageObjects.class);
	Scenario scn;
	
	private By txt_username = By.xpath("//*[@id=\"EmailAddress\"]");
	private By txt_password = By.xpath("//*[@id=\"Password\"]");
	private By btn_continue = By.xpath("/html/body/div/main/div/div/div/div/form/div[3]/button/span[2]");
	private By txt_logout = By.xpath("/html/body/app/div/div[1]/div/div[2]/div/div");
	
	public LoginPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	
}
