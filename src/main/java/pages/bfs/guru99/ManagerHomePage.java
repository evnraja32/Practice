package pages.bfs.guru99;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ExtentReporter;
import wrapper.PageFactoryWrapper;

public class ManagerHomePage extends PageFactoryWrapper{

	public ManagerHomePage() {
		String expTitle = "Guru99 Bank Manager HomePage";
		if(!verifyWindowTitle(expTitle)){
			ExtentReporter.reportStep("<p style=\"color:red\">Expected Page: "+expTitle+"<br>"
					+ "Actual Page: "+currentWindowTitle()+"</p>","FATAL");
		}else{
			PageFactory.initElements(driver, this);
			ExtentReporter.reportStep("<p style=\"color:green\">\""+expTitle+"\" Page Landed</p>","PASS");
			
		}
	}
	
	public ManagersMenu fromManagersMenu(){
		return new ManagersMenu();
	}
	
	@FindBy(css="tr.heading3 > td")
	WebElement managerIDL;
	public String getManagerID(){
		return managerIDL.getText().split(" : ")[0];
	}

	
}
