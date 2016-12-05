package testcases.bfs.guru99tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import pages.bfs.guru99.BalanceEnquiryPage;
import pages.bfs.guru99.Guru99BankHomePage;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC029_ManagersMenuNavTest extends TestNGPageFactoryWrapper{

	@BeforeClass
	public void setWebPageCofig(){
		testCaseName = "TC029 Balance Enquery Screen Navigation Test";
		testCaseDesc = "To Check whether the web page is properly navigating to balance enquery web page and returning the remaining amount or not";
		browser = TargetBrowser.FIREFOX;
		url = "http://demo.guru99.com/V4";
	}


	@Test
	public void testMethod() {
		try {
		new Guru99BankHomePage()
			.enterUserName("mngr55367")
			.enterPassword("EbaqYma")
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
