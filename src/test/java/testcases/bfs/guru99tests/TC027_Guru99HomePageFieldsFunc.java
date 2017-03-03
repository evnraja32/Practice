package testcases.bfs.guru99tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.bfs.guru99.Guru99BankHomePage;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC027_Guru99HomePageFieldsFunc extends TestNGPageFactoryWrapper{

	@BeforeClass
	public void setWebPageCofig(){
		testCaseName = "TC027 Field Functionality Test";
		testCaseDesc = "Verify ";
		browser = TargetBrowser.FIREFOX;
		url = "http://demo.guru99.com/V4";
	}


	@Test
	@Parameters({"username","password"})
	public void testMethod(String username,String password) {
		new Guru99BankHomePage()
		.enterUserName(username)
		.enterPassword(password)
		.clickResetBTN();
	}






}
