package testcases.testngtcs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC021_GridSampleIE {
	private DesiredCapabilities desiredCapabilities = null;
	protected URL remoteAddress = null;
	protected RemoteWebDriver driver = null;
	protected String siteURL = "";

	@BeforeSuite
	public void beforeSuite() throws MalformedURLException {
		remoteAddress = new URL("http://192.168.23.139:4444/wd/hub");
	}

	@BeforeClass
	public void beforeClass() {
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setBrowserName("internet explorer");
		desiredCapabilities.setVersion("8");
		desiredCapabilities.setPlatform(Platform.WINDOWS);

		siteURL = "https://sweetalert.js.org/";

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new RemoteWebDriver(remoteAddress, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test // (invocationCount = 3, threadPoolSize = 2)
	public void testMethod() throws MalformedURLException, InterruptedException {

		driver.get(siteURL);
		FluentWait<RemoteWebDriver> waitEvent = new FluentWait<RemoteWebDriver>(driver);
		WebElement alertButton = waitEvent.withTimeout(30, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='page-container']/div/button[@class='preview'])[1]")));
		alertButton.click();
		
		Thread.sleep(5000);

		Alert a = driver.switchTo().alert();
		a.accept();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
