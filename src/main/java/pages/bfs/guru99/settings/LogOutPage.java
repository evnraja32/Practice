package pages.bfs.guru99.settings;

import org.openqa.selenium.support.PageFactory;

import pages.bfs.guru99.Guru99BankHomePage;
import pages.bfs.guru99.ManagersMenu;
import util.AlertAction;
import util.ExtentReporter;
import wrapper.PageFactoryWrapper;

public class LogOutPage extends PageFactoryWrapper {

	public LogOutPage() {
		switchToWindowAlert();
		manageAlert(AlertAction.ACCEPT);

		String expTitle = "Guru99 Bank Logout Output Page";
		if (!verifyWindowTitle(expTitle)) {
			ExtentReporter.reportStep("<p style=\"color:red\">Expected Page: " + expTitle + "<br>" + "Actual Page: "
					+ currentWindowTitle() + "</p>", "FATAL");
		} else {
			PageFactory.initElements(driver, this);
			ExtentReporter.reportStep("<p style=\"color:green\">\"" + expTitle + "\" Page Landed</p>", "PASS");
		}
	}
	
	public Guru99BankHomePage isHomePage(){
		return new Guru99BankHomePage();
	}

	public ManagersMenu fromManagersMenu() {
		return new ManagersMenu();
	}
}
