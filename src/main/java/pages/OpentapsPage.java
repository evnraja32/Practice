package pages;

import wrapper.SimpleSeleniumWrapper;

public class OpentapsPage extends SimpleSeleniumWrapper{
	
	public OpentapsPage() {
		if(!verifyWindowTitle("My Home | opentaps CRM")){
			closeTheBrowser();
			throw new RuntimeException();
		}
	}
	
	public OpentapsPage pageStatus(){
		
		System.out.println("Successfull login");
		closeTheBrowser();
		
		return this;
	}
	
	
}
