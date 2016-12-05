package pages.bfs.guru99;

import org.openqa.selenium.support.PageFactory;

import wrapper.PageFactoryWrapper;

public class DeleteAccountPage extends PageFactoryWrapper {

	public DeleteAccountPage(){
		PageFactory.initElements(driver, this);
	}
	
	public ManagersMenu fromManagersMenu(){
		return new ManagersMenu();
	}
}
