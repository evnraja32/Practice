package pages.bfs.guru99.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.bfs.guru99.ManagerHomePage;
import pages.bfs.guru99.ManagersMenu;
import util.ExtentReporter;
import wrapper.PageFactoryWrapper;

public class NewCustomerPage extends PageFactoryWrapper {

	public NewCustomerPage() {
		String expTitle = "Guru99 Bank New Customer Entry Page";
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

	@FindBy(css = "input[name='name']")
	WebElement customerNameTF;

	@FindBy(css = "input[value='m']")
	WebElement maleGenderBT;

	@FindBy(css = "input[value='f']")
	WebElement femaleGenderBT;

	@FindBy(id = "dob")
	WebElement dobTF;

	@FindBy(css = "textarea[name='addr']")
	WebElement addressTF;

	@FindBy(name = "city")
	WebElement cityTF;

	@FindBy(name = "state")
	WebElement stateTF;

	@FindBy(name = "pinno")
	WebElement pinTF;

	@FindBy(name = "telephoneno")
	WebElement mobileTF;

	@FindBy(name = "emailid")
	WebElement emailTF;

	@FindBy(name = "password")
	WebElement passwordTF;

	@FindBy(css = "input[type='submit']")
	WebElement submitBTN;

	public NewCustomerPage pressSubmitBTN() {
		submitBTN.click();
		return this;
	}

	@FindBy(css = "input[type='reset']")
	WebElement resetBTN;

	public NewCustomerPage pressResetBTN() {
		resetBTN.click();
		return this;
	}

	@FindBy(linkText = "Home")
	WebElement homeLink;

	public ManagerHomePage clickHomeLink() {
		homeLink.click();
		return new ManagerHomePage();
	}

	@FindBy(linkText = "Continue")
	WebElement continueLink;

	public ManagerHomePage clickContinueLink() {
		continueLink.click();
		return new ManagerHomePage();
	}

}
