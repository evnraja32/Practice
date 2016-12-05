package pages.bfs.guru99;

import org.openqa.selenium.support.PageFactory;

import wrapper.PageFactoryWrapper;

public class NewCustomerPage extends PageFactoryWrapper{

	public NewCustomerPage(){
		PageFactory.initElements(driver, this);
	}
	
	public ManagersMenu fromManagersMenu(){
		return new ManagersMenu();
	}

}
