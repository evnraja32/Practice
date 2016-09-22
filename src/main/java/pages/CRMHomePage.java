package pages;

import wrapper.SimpleSeleniumWrapper;

public class CRMHomePage extends SimpleSeleniumWrapper{
	
	public CRMHomePage() {
		if(!verifyWindowTitle("Opentaps Open Source ERP + CRM")){
			throw new RuntimeException();
		}
	}
	
	public CRMHomePage clickOnCRM_SFA_Module(){

		findWebElementByLinkText("CRM/SFA");
		clickOnElement();

		return new CRMHomePage();
	}
}
