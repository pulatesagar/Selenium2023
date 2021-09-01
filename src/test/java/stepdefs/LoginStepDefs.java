package stepdefs;
import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
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

public class LoginStepDefs extends TestBase {
	TestContextUI testContextUI;
	Scenario scn;

	public LoginStepDefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	

@When("^user enters (.*) and (.*)$")
public void user_enters_username_and_password(String username, String password) {
	testContextUI.loginPageObjects().enterUsername(username);
	testContextUI.loginPageObjects().enterPassword(password);
}

@And("user clicks on login button")
public void user_clicks_on_login_button() {
	testContextUI.loginPageObjects().pressLogin();
}

@Then("user should be redirected to dashboard")
public void user_should_be_redirected_to_dashboard() {
	testContextUI.loginPageObjects().checkUserMenuIsDisplayed();
}

@Then("It should show error message")
public void it_should_show_error_message() {
	String actual = (String) testContextUI.loginPageObjects().loginError();
	String message = "Unknown Account\nWe are unable to locate that email address and password combination in our database. Please check your input and try again, or Click Here to Reset Your Password.";
	assertThat(message,CoreMatchers.containsString(actual));
}


	
}