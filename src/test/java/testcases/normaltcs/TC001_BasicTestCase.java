package testcases.normaltcs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC001_BasicTestCase {
/**
 * The intenstion of this test case is to check for successfull navigation
 * 
 * Expected Result: when submit button in "Register Page" is clicked the Page should land into "Forms action page".
 * 
 * @param args
 */
	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.marionette", "./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("file:///H:/Practice/src/main/java/htmlpages/registerpage.html");
		
		//Step1: identify firstname
		WebElement firstName = driver.findElement(By.id("firstname"));
		//Step2: identify lastname
		WebElement lastName = driver.findElement(By.id("lastname"));
		//Step3: click on Submit
		WebElement clickButton = driver.findElement(By.id("submit"));
		
		firstName.clear();
		firstName.sendKeys("Demo1");
		
		lastName.clear();
		lastName.sendKeys("Demo1");
		
		clickButton.click();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		if(driver.getTitle().equals("Forms action page")){
			System.out.println("Test Case Success");
		}else{
			System.err.println("Test Case Failed");
		}
		
		driver.quit();
	}

}
