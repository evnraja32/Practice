package pages;

import wrapper.SimpleSeleniumWrapper;

public class CRMLoginPage extends SimpleSeleniumWrapper{

	public CRMLoginPage(){
		if(!verifyWindowTitle("Opentaps Open Source ERP + CRM")){
			throw new RuntimeException();
		}
	}

	public CRMLoginPage enterUserName(){

		findWebElementByID("username");
		sendKeysToWebElement("DemoSalesManager");

		return new CRMLoginPage();
	}
	public CRMLoginPage enterPassword(){

		findWebElementByID("password");
		sendKeysToWebElement("crmsfa");

		return new CRMLoginPage();
	}

	public CRMHomePage clickLoginButton(){

		findWebElementByCssSelector("input.decorativeSubmit");
		clickOnElement();
		
		return new CRMHomePage();
	}

}
