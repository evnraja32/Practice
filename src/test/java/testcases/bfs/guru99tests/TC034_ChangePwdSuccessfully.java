package testcases.bfs.guru99tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.bfs.guru99.Guru99BankHomePage;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC034_ChangePwdSuccessfully extends TestNGPageFactoryWrapper {

	@BeforeClass
	public void setWebPageCofig() {
		testCaseName = "TC034 Change Pwd Successfully";
		testCaseDesc = "To Check functionality of submit button";
		browser = TargetBrowser.EDGE;
		url = "http://demo.guru99.com/V4";
	}

	@Test
	@Parameters({ "username", "password" })
	public void testMethod(String username, String password) {
		try {
			 new Guru99BankHomePage().enterUserName(username)
					.enterPassword(password).clickLoginBTN().fromManagersMenu().clickChangePasswordPageLink()
					.enterOldPassword("R@ja136900").enterNewPassword("RaJ@136900").enterConfirmPassword("RaJ@136900")
					.pressSubmitButton().enterUserName(username).enterPassword(password).clickLoginBTN();

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
