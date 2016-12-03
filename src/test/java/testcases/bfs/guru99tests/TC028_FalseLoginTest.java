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
		testCaseName = "Field Functionality";
		testCaseDesc = "Verify ";
		browser = TargetBrowser.FIREFOX;
		url = "http://demo.guru99.com/V4";
		System.out.println("before class "+browser + "   "+ url);
	}


	@Test
	public void testMethod() {
		try{
		new Guru99BankHomePage()
		.enterUserName("mngr55367")
		.enterPassword("EbaqY")
		.clickResetBTN();
		}catch(RuntimeException e){
			switchToWindowAlert();
			manageAlert(AlertAction.ACCEPT);
			
		}
	}






}
