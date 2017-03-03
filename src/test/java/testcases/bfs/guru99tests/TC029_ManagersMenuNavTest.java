package testcases.bfs.guru99tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pages.bfs.guru99.Guru99BankHomePage;
import pages.bfs.guru99.transaction.BalanceEnquiryPage;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC029_ManagersMenuNavTest extends TestNGPageFactoryWrapper{

	@BeforeClass
	public void setWebPageCofig(){
		testCaseName = "TC029 Managers Menu Navigation Test";
		testCaseDesc = "To Check whether the web page is properly navigating to all the Menu items displayed";
		browser = TargetBrowser.FIREFOX;
		url = "http://demo.guru99.com/V4";
	}


	@Test
	@Parameters({"username","password"})
	public void testMethod(String username,String password) {
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
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






}
