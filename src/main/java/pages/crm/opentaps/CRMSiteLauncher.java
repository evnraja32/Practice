package pages.crm.opentaps;

import wrapper.SimpleSeleniumWrapper;

public class CRMSiteLauncher extends SimpleSeleniumWrapper{

	public CRMLoginPage launchAppIn(String browser){
		launchApp(browser, "http://demo1.opentaps.org/");
		
		return new CRMLoginPage();
	}
}
