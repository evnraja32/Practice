package testcases.bfs.guru99tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.bfs.guru99.Guru99BankHomePage;
import util.AlertAction;
import util.TargetBrowser;
import wrapper.TestNGPageFactoryWrapper;

public class TC028_FalseLoginTest extends TestNGPageFactoryWrapper{

	@BeforeClass
	public void setWebPageCofig(){
		testCaseName = "TC028 False Login Test";
		testCaseDesc = "Verify ";
		browser = TargetBrowser.FIREFOX;
		url = "http://demo.guru99.com/V4";
	}

	@Test
	public void testMethod() {
		try{
			new Guru99BankHomePage()
			.enterUserName("Invalid Username")
			.enterPassword("Invalid Password")
			.clickLoginBTN();
		}catch(RuntimeException e){
			manageAlert(AlertAction.ACCEPT);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
	}






}
