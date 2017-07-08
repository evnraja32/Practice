package testcases.normaltcs;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridTestCase001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.ie.driver","./driver/IEDriverServer.exe");
		 System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setPlatform(Platform.WINDOWS);
		desiredCapabilities.setBrowserName("MicrosoftEdge");
		RemoteWebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.23.1:4444/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("www.google.com");
		driver.quit();
	}

}
