package testcases.bfs.guru99tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.bfs.guru99.Guru99BankHomePage;
import pages.bfs.guru99.settings.ChangePasswordPage;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC033_ChangePwdPressReset extends TestNGPageFactoryWrapper {

	@BeforeClass
	public void setWebPageCofig() {
		testCaseName = "TC033 Change Pwd Reset";
		testCaseDesc = "To Check functionality of reset button";
		browser = TargetBrowser.INTERNETEXPLORER;
		url = "http://demo.guru99.com/V4";
	}

	@Test
	@Parameters({ "username", "password" })
	public void testMethod(String username, String password) {
		try {
			ChangePasswordPage changePasswordPage = new Guru99BankHomePage().enterUserName(username)
					.enterPassword(password).clickLoginBTN().fromManagersMenu().clickChangePasswordPageLink()
					.enterOldPassword("alsdkf").enterNewPassword("asdf").enterConfirmPassword("dsafd")
					.pressResetButton();

			Assert.assertEquals(changePasswordPage.getOldPassword(),"");
			Assert.assertEquals(changePasswordPage.getNewPassword(),"");
			Assert.assertEquals(changePasswordPage.getConfirmPassword(),"");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
