package pages.crm.opentaps;

import wrapper.SimpleSeleniumWrapper;

public class CRMLoginPage extends SimpleSeleniumWrapper{

	public CRMLoginPage(){
		if(!verifyWindowTitle("Opentaps Open Source ERP + CRM")){
			throw new RuntimeException();
		}
	}

	public CRMLoginPage enterUserName(String username){

		findWebElementByID("username");
		sendKeysToWebElement(username);

		return new CRMLoginPage();
	}
	public CRMLoginPage enterPassword(String password){

		findWebElementByID("password");
		sendKeysToWebElement(password);

		return new CRMLoginPage();
	}

	public CRMHomePage clickLoginButton(){

		findWebElementByCssSelector("input.decorativeSubmit");
		clickOnElement();
		
		return new CRMHomePage();
	}

}
