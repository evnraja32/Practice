package testcases.testngtcs;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class TC012_ScreenShotInRemoteIE {

	@Test//(invocationCount = 3, threadPoolSize = 2)	
	public void fte() throws WebDriverException, IOException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setBrowserName("internet explorer");

		URL remoteAddress = new URL("http://192.168.23.131:4444/wd/hub");

		RemoteWebDriver driver = new RemoteWebDriver(remoteAddress,desiredCapabilities);

		driver.get("http://t4t5.github.io/sweetalert/");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='showcase normal']/button")));
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
        try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./output/reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.quit();

	}
}
