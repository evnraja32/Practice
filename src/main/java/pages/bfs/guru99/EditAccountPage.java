package pages.bfs.guru99;

import org.openqa.selenium.support.PageFactory;

import wrapper.PageFactoryWrapper;

public class EditAccountPage extends PageFactoryWrapper{

	public EditAccountPage(){
		PageFactory.initElements(driver, this);
	}
	
	public ManagersMenu fromManagersMenu(){
		return new ManagersMenu();
	}
}
