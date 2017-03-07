package testcases.bfs.guru99tests;

import org.openqa.selenium.UnhandledAlertException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.bfs.guru99.Guru99BankHomePage;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC029_ManagersMenuNavTest extends TestNGPageFactoryWrapper {

	@BeforeClass
	public void setWebPageCofig() {
		testCaseName = "TC029 Managers Menu Navigation Test";
		testCaseDesc = "To Check whether the web page is properly navigating to all the Menu items displayed";
		browser = TargetBrowser.EDGE;
		url = "http://demo.guru99.com/V4";
	}

	@Test()
	@Parameters({ "username", "password" })
	public void testMethod(String username, String password) {
		try {
			new Guru99BankHomePage()
			.enterUserName(username)
			.enterPassword(password)
			.clickLoginBTN()
			.fromManagersMenu()
			.clcikDeleteAccountPageLink()
			.fromManagersMenu()
			.clickCustomisedStatementPageLink()
			.fromManagersMenu()
			.clickNewAccountPageLink()
			.fromManagersMenu()
			.clickBalanceEnquiryPageLink()
			.fromManagersMenu()
			.clickNewCustomerPageLink()
			.fromManagersMenu()
			.clickLogOutPageLink()
			.isHomePage();
		}catch( UnhandledAlertException e){
			if (switchToWindowAlert()) {
				System.out.println("Text on the Alert: " + getAlertText());
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
