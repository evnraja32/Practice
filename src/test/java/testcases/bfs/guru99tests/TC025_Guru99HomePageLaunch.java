package testcases.bfs.guru99tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pages.bfs.guru99.Guru99BankHomePage;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC025_Guru99HomePageLaunch extends TestNGPageFactoryWrapper{

	@BeforeClass
	public void setWebPageCofig(){
		testCaseName = "TC025 Home Launch HomePage";
		testCaseDesc = "Verify Launching Bank Home Page";
		browser = TargetBrowser.FIREFOX;
		url = "http://demo.guru99.com/V4";
	}


	@Test
	public void testMethod() {
		try {
			new Guru99BankHomePage()
			.enterUserName("mngr59123")
			.enterPassword("mYdUhUp")
			.clickLoginBTN();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






}
