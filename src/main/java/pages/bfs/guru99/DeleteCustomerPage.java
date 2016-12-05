package pages.bfs.guru99;

import org.openqa.selenium.support.PageFactory;

import util.ExtentReporter;
import wrapper.PageFactoryWrapper;

public class DeleteCustomerPage extends PageFactoryWrapper{

	public DeleteCustomerPage() {
		String expTitle = "Guru99 Bank Delete Customer Page";
		if (!verifyWindowTitle(expTitle)) {
			ExtentReporter.reportStep("<p style=\"color:red\">Expected Page: " + expTitle + "<br>" + "Actual Page: "
					+ currentWindowTitle() + "</p>", "FATAL");
		} else {
			PageFactory.initElements(driver, this);
			ExtentReporter.reportStep("<p style=\"color:green\">\"" + expTitle + "\" Page Landed</p>", "PASS");

		}
	}
	
	public ManagersMenu fromManagersMenu(){
		return new ManagersMenu();
	}
	
}
