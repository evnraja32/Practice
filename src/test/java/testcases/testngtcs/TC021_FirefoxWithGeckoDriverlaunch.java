package testcases.testngtcs;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.AlertAction;
import wrapper.TestNGWrapper;

public class TC021_FirefoxWithGeckoDriverlaunch extends TestNGWrapper{

	@BeforeClass
	public void setWebPageCofig(){
		browser = "firefox";
		url = "http://t4t5.github.io/sweetalert/";

	}


	@Test()
	public void testCase() {
		locateElementByXpath("//div[@class='showcase normal']/button");
		clickOnElement();
		switchToWindowAlert();
		manageAlert(AlertAction.ACCEPT);
	}
}
