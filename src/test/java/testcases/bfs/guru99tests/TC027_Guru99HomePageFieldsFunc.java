package testcases.bfs.guru99tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.bfs.guru99.Guru99BankHomePage;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC027_Guru99HomePageFieldsFunc extends TestNGPageFactoryWrapper{

	@BeforeClass
	public void setWebPageCofig(){
		testCaseName = "Field Functionality";
		testCaseDesc = "Verify ";
		browser = TargetBrowser.FIREFOX;
		url = "http://demo.guru99.com/V4";
		System.out.println("before class "+browser + "   "+ url);
	}


	@Test
	public void testMethod() {
		new Guru99BankHomePage()
		.enterUserName("mngr55367")
		.enterPassword("EbaqYma")
		.clickResetBTN();
	}






}
