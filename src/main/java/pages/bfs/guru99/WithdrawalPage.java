package pages.bfs.guru99;

import org.openqa.selenium.support.PageFactory;

import wrapper.PageFactoryWrapper;

public class WithdrawalPage extends PageFactoryWrapper{

	public WithdrawalPage(){
		PageFactory.initElements(driver, this);
	}
	
	public ManagersMenu fromManagersMenu(){
		return new ManagersMenu();
	}
}
