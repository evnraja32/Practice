package testcases.bfs.guru99tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pages.bfs.guru99.Guru99BankHomePage;
import pages.bfs.guru99.transaction.BalanceEnquiryPage;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC030_BalanceEnqueryScreenNavTest extends TestNGPageFactoryWrapper{

	@BeforeClass
	public void setWebPageCofig(){
		testCaseName = "TC030 Balance Enquery Screen Navigation Test";
		testCaseDesc = "To Check whether the web page is properly navigating to balance enquery web page and returning the remaining amount or not";
		browser = TargetBrowser.FIREFOX;
		url = "http://demo.guru99.com/V4";
	}


	@Test
	@Parameters({"username","password"})
	public void testMethod(String username,String password) {
		try {
			BalanceEnquiryPage balanceEnquiryPage = new Guru99BankHomePage()
			.enterUserName(username)
			.enterPassword(password)
			.clickLoginBTN()
			.fromManagersMenu()
			.clickBalanceEnquiryPageLink()
			.enterAccountNumber("19782")
			.pressSubmitBTN();
			
			Assert.assertEquals(balanceEnquiryPage.getAccountBalance(), "150");
			
			balanceEnquiryPage.
			clickContinueLink()
			.fromManagersMenu()
			.clickLogOutPageLink()
			.isHomePage();
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






}
