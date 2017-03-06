package pages.bfs.guru99.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pages.bfs.guru99.Guru99BankHomePage;
import pages.bfs.guru99.ManagersMenu;
import util.ExtentReporter;
import wrapper.PageFactoryWrapper;

public class ChangePasswordPage extends PageFactoryWrapper {

	public ChangePasswordPage() {
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

	public ChangePasswordPage enterOldPassword(String oldPassword) {

		WebElement oldPWDTF = driver.findElement(By.xpath(prop.getProperty("oldPWDTF.LV")));
		oldPWDTF.clear();
		oldPWDTF.sendKeys(oldPassword);

		return new ChangePasswordPage();
	}

	public ChangePasswordPage enterNewPassword(String newPassword) {
		WebElement newPWD = driver.findElement(By.xpath(prop.getProperty("newPWDTF.LV")));
		newPWD.clear();
		newPWD.sendKeys(newPassword);

		return new ChangePasswordPage();
	}

	public ChangePasswordPage enterConfirmPassword(String confirmPassowrd) {
		locateElementByXpath(prop.getProperty("confimrPWDTF.LV"));
		sendKeysToWebElement(confirmPassowrd);

		return new ChangePasswordPage();
	}

	public Guru99BankHomePage pressSubmitButton() throws InterruptedException {
		locateElementByXpath(prop.getProperty("submitBT.LV"));
		clickOnElement();
		Thread.sleep(5000);
		return new Guru99BankHomePage();
	}

	public ChangePasswordPage pressResetButton() {
		locateElementByXpath(prop.getProperty("resetBT.LV"));
		clickOnElement();

		return new ChangePasswordPage();
	}

	public String getOldPassword() {
		locateElementByXpath(prop.getProperty("oldPWDTF.LV"));

		return element.getText();
	}
	
	public String getNewPassword() {
		locateElementByXpath(prop.getProperty("newPWDTF.LV"));

		return element.getText();
	}

	public String getConfirmPassword() {
		locateElementByXpath(prop.getProperty("confirmPWDTF.LV"));

		return element.getText();
	}

}
