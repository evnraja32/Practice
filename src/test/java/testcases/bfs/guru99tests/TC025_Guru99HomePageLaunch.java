package testcases.bfs.guru99tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pages.bfs.guru99.Guru99BankHomePage;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC025_Guru99HomePageLaunch extends TestNGPageFactoryWrapper{

	@BeforeClass
	public void setWebPageCofig(){
		testCaseName = "Launch HomePage";
		testCaseDesc = "Verify Launching Bank Home Page";
		browser = TargetBrowser.FIREFOX;
		url = "http://demo.guru99.com/V4";
		System.out.println("before class "+browser + "   "+ url);
	}


	@Test
	public void testMethod() {
		try {
			new Guru99BankHomePage()
			.enterUserName("mngr55367")
			.enterPassword("EbaqYma")
			.clickLoginBTN();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






}
