package testcases.testngtcs;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.AlertAction;
import wrapper.TestNGWrapper;

public class TC020_SweetAlertsNormalAlert extends TestNGWrapper{

	@BeforeClass
	public void setWebPageCofig(){
		browser = "firefox";
		url = "http://t4t5.github.io/sweetalert/";

	}

	@Test()
	public void testCase() throws WebDriverException, IOException {

		//=== Nornmal Alert ==

		locateElementByXpath("//div[@class='showcase normal']/button");
		clickOnElement();

		switchToWindowAlert();
		manageAlert(AlertAction.ACCEPT);

		//=====================

		//=== HTML Alerts ===
		
		//click on alert button to get the alert message
		locateElementByCssSelector("li.message-html div.ui button");
		clickOnElement();

		//After Pressing
		takeScreenShot("HTML_Alert_ScreenShot_Before");
		
		locateElementByCssSelector("div.sa-confirm-button-container button");
		clickOnElement();

		takeScreenShot("HTML_Alert_ScreenShot_After");

		//=====================

		//=== HTML Alerts contains text message after entering text it displays the message on the alert ===

		locateElementByCssSelector("li.input div.ui button");
		clickOnElement();
		
		takeScreenShot("ScreenShot1");
		
		locateElementByCssSelector("fieldset input");
		sendKeysToWebElement("Alert Sample");
		
		takeScreenShot("ScreenShot2");
		
		locateElementByCssSelector("button.confirm");
		clickOnElement();

		takeScreenShot("ScreenShot3");
		

		locateElementByCssSelector("div.sa-confirm-button-container button");
		clickOnElement();

		takeScreenShot("ScreenShot4");

		//=====================
	}
}
