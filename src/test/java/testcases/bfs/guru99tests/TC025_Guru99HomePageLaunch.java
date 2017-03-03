package testcases.bfs.guru99tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

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
	@Parameters({"username","password"})
	public void testMethod(String username,String password) {
		try {
			new Guru99BankHomePage()
			.enterUserName(username)
			.enterPassword(password)
			.clickLoginBTN();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






}
