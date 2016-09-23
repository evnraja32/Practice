package testcases.normaltcs.crmpage;

import pages.CRMSiteLauncher;

public class TC025_CRMLoginTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CRMSiteLauncher()
		.launchAppIn("chrome")
		.enterUserName("DemoSalesManager")
		.enterPassword("crmsfa")
		.clickLoginButton()
		.clickOnCRM_SFA_Module()
		.getPageStatus(); // change method name to getPageStatus();
	}

}
