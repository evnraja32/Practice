package testcases.bfs.guru99tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.bfs.guru99.Guru99BankHomePage;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC032_ChangePWDScreenNav extends TestNGPageFactoryWrapper {

	@BeforeClass
	public void setWebPageCofig() {
		testCaseName = "TC032 Change Password Screen Navigation";
		testCaseDesc = "To Check Page navigation to Change Password Screen";
		browser = TargetBrowser.INTERNETEXPLORER;
		url = "http://demo.guru99.com/V4";
	}

	@Test
	@Parameters({ "username", "password" })
	public void testMethod(String username, String password) {
		try {
			new Guru99BankHomePage().enterUserName(username)
			.enterPassword(password)
			.clickLoginBTN()
			.fromManagersMenu()
			.clickChangePasswordPageLink()
			.fromManagersMenu()
			.clickLogOutPageLink();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
