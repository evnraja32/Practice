package pages.bfs.guru99.account;

import org.openqa.selenium.support.PageFactory;

import pages.bfs.guru99.ManagersMenu;
import util.ExtentReporter;
import wrapper.PageFactoryWrapper;

public class NewAccountPage extends PageFactoryWrapper {

	public NewAccountPage() {
		String expTitle = "Guru99 bank add new account";
		if (!verifyWindowTitle(expTitle)) {
			ExtentReporter.reportStep("<p style=\"color:red\">Expected Page: " + expTitle + "<br>" + "Actual Page: "
					+ currentWindowTitle() + "</p>", "FATAL");
		} else {
			PageFactory.initElements(driver, this);
			ExtentReporter.reportStep("<p style=\"color:green\">\"" + expTitle + "\" Page Landed</p>", "PASS");

		}
	}

	public ManagersMenu fromManagersMenu() {
		return new ManagersMenu();
	}
}
