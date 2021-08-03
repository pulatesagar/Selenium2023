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
	
	private By txt_username = By.xpath("//*[@id=\"EmailAddressTextBox\"]");
	private By txt_password = By.xpath("//*[@id=\"PasswordTextBox\"]");
	private By btn_login = By.xpath("//*[@id=\"LoginButton\"]");
	private By lnk_signOut = By.xpath("//*[@id=\"topNav\"]/div/div/div[2]/ul[2]/li/ul/li[5]/a");
	private By toast_loginError = By.xpath("//*[@id=\"toast-container\"]");
	

	
	
	
	
	public LoginPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	public void enterUsername(String username)
	{
		setElement(txt_username, username);
	}

	public void enterPassword(String password)
	{
		
		setElement(txt_password, password);
	}

	public void pressLogin() {
		
		clickElement(btn_login);
		
		
	}
	public void checkUserMenuIsDisplayed() {
		
		validateElementIsDisplayed(lnk_signOut);
	}
    public String loginError() {
		
		String message = getText(toast_loginError);
		return message;
	
		

		
	}   
	
}
