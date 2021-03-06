package testcases.normaltcs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TC001_BasicTestCase {
	/**
	 * The intenstion of this test case is to check for successfull navigation
	 * 
	 * Expected Result: when submit button in "Register Page" is clicked the
	 * Page should land into "Forms action page".
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "./drivers/geckodriver.exe"); WebDriver driver = new FirefoxDriver();
		 */

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(capabilities);

		driver.get("file:///H:/Practice/src/main/resources/codingbasics/htmlpages/registerpage.html");

		// Step1: identify firstname
		WebElement firstName = driver.findElement(By.id("firstname"));
		// Step2: identify lastname
		WebElement lastName = driver.findElement(By.id("lastname"));
		// Step3: click on Submit
		WebElement clickButton = driver.findElement(By.id("submit"));

		firstName.clear();
		firstName.sendKeys("Demo1");

		lastName.clear();
		lastName.sendKeys("Demo1");

		clickButton.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		if (driver.getTitle().equals("Forms action page")) {
			System.out.println("Test Case Success");
		} else {
			System.err.println("Test Case Failed");
		}

		driver.quit();
	}

}
