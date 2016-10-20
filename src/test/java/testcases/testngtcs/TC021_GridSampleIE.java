package testcases.testngtcs;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TC021_GridSampleIE {
	
	@Test(invocationCount = 3, threadPoolSize = 2)	
	public void fte() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setBrowserName("internet explorer");

		URL remoteAddress = new URL("http://192.168.23.131:4444/wd/hub");

		RemoteWebDriver driver = new RemoteWebDriver(remoteAddress,desiredCapabilities);

		driver.get("http://t4t5.github.io/sweetalert/");

		driver.findElementByXPath("//div[@class='showcase normal']/button").click();

		Alert a = driver.switchTo().alert();

		a.accept();

		driver.quit();



	}
}
