package testcases.bfs.guru99tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.bfs.guru99.Guru99BankHomePage;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC031_MiniaStmtNavTest extends TestNGPageFactoryWrapper {

	@BeforeClass
	public void setWebPageCofig() {
		testCaseName = "TC031 Mini Statement Screen Navigation Test";
		testCaseDesc = "To Check whether the web page is properly navigating to Mini Statement Page";
		browser = TargetBrowser.EDGE;
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
			.clickMiniStatementPageLink()
			.fromManagersMenu()
			.clickLogOutPageLink();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
