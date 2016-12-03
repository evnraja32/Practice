package pages.crm.opentaps;

import wrapper.SimpleSeleniumWrapper;

public class CRMHomePage extends SimpleSeleniumWrapper{
	
	public CRMHomePage() {
		if(!verifyWindowTitle("Opentaps Open Source ERP + CRM")){
			throw new RuntimeException();
		}
	}
	
	public OpentapsPage clickOnCRM_SFA_Module(){

		findWebElementByLinkText("CRM/SFA");
		clickOnElement();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new OpentapsPage();
	}
}
