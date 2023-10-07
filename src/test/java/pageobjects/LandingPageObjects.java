package pageobjects;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;

import utils.ui.Interact;

public class LandingPageObjects extends Interact {

	private static final Logger logger = LogManager.getLogger(LandingPageObjects.class);
	Scenario scn;


	private By searchBox = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
	private By searchButton = By.xpath("//*[@id=\"nav-search-submit-button\"]");
	private By clikMebtn = By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button");
	
	


	public LandingPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}

	public void urlValidate()
	{
		boolean status = validateElementIsDisplayed(searchBox);
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

	public void navigateUrl(String string) {

		{
			getDriver().get(string);
		}
	}

	public void searchProducts(String string) {

		{
			setElement(searchBox, string);
			clickElement(searchButton);
		}
	}

	public void saveProductUrl() {

		{
			String urlToClick=null;
			urlToClick = getDriver().findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/span/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span")).getAttribute("href");
		
			System.out.println("The expected URL"+ urlToClick);
			Set<String> handles=getDriver().getWindowHandles();
			for(String actual: handles) 
			{
				String currentHandle = null;
				if(!actual.equalsIgnoreCase(currentHandle)) 
				{
					//Switch to the opened tab
					getDriver().switchTo().window(actual); 
					//opening the URL saved.
					getDriver().get(urlToClick);

				}
			}

		}
	}


	public void openNewTab() {

		{
            //empty
        }
	}
	public void clickOnClickMeDemo() throws InterruptedException {

		{
			
            clickElement(clikMebtn);
            //testing
        }
	}
	public void acceptOK() throws InterruptedException {

		{
			
	

            Alert alert = getDriver().switchTo().alert();
            String alertMessage= getDriver().switchTo().alert().getText(); // capture alert message

            System.out.println(alertMessage); // Print Alert Message
            Thread.sleep(1000);
            alert.accept();
        }
	}
	public void cancelButton() throws InterruptedException {

		{
			
			getDriver().navigate().refresh();
			clickElement(clikMebtn);
			Thread.sleep(5000);
            Alert alert = getDriver().switchTo().alert();
            String alertMessage= getDriver().switchTo().alert().toString();

            System.out.println(alertMessage); // Print Alert Message
    
            alert.dismiss();
        }
	}
	
	public void childWindowHandle() throws InterruptedException {
		
		 // Open new window by clicking the button
		getDriver().findElement(By.id("windowButton")).click();
		
		Thread.sleep(2000);
		  //Get handles of the windows
        String mainWindowHandle = getDriver().getWindowHandle();
        System.out.println("This is main WindowID"+mainWindowHandle);
        Set<String> allWindowHandles = getDriver().getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                System.out.println("This is child WindowID"+ChildWindow);
                getDriver().switchTo().window(ChildWindow);
                WebElement text = getDriver().findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
            }
        }

	}
	
	public void iframeTestJavaScript() throws InterruptedException {

		{
			
			//By executing a java script
			JavascriptExecutor exe = (JavascriptExecutor) getDriver();
			Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
			System.out.println("Number of iframes on the page are by Javascript executer " + numberOfFrames);
			//Switch by Index
			getDriver().switchTo().frame(0);
			String l = getDriver().findElement(By.tagName("body")).getText();
			System.out.println(l);
			
	
			
			

	
        }
	}
	public void iframeTestByTagName() throws InterruptedException {

		{

			//By finding all the web elements using iframe tag
			List<WebElement> iframeElements = getDriver().findElements(By.tagName("iframe"));
			System.out.println("The total number of iframes are by tagname " + iframeElements.size());
			getDriver().switchTo().frame("iframe1");
			getDriver().getPageSource();
		
			

	
        }
	}
}

	
