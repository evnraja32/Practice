package pages.bfs.guru99;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.bfs.guru99.account.DeleteAccountPage;
import pages.bfs.guru99.account.EditAccountPage;
import pages.bfs.guru99.account.NewAccountPage;
import pages.bfs.guru99.customer.DeleteCustomerPage;
import pages.bfs.guru99.customer.EditCustomerPage;
import pages.bfs.guru99.customer.NewCustomerPage;
import pages.bfs.guru99.settings.ChangePasswordPage;
import pages.bfs.guru99.settings.LogOutPage;
import pages.bfs.guru99.transaction.BalanceEnquiryPage;
import pages.bfs.guru99.transaction.CustomisedStatementPage;
import pages.bfs.guru99.transaction.DepositPage;
import pages.bfs.guru99.transaction.FundTransferPage;
import pages.bfs.guru99.transaction.MiniStatementPage;
import pages.bfs.guru99.transaction.WithdrawalPage;
import util.AlertAction;
import wrapper.PageFactoryWrapper;

public class ManagersMenu extends PageFactoryWrapper {

	public ManagersMenu() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Manager")
	WebElement managerLink;

	public ManagerHomePage clickManagerPageLink() throws InterruptedException {
		managerLink.click();
		Thread.sleep(5000);
		return new ManagerHomePage();
	}

	@FindBy(linkText = "New Customer")
	WebElement newCustomerLink;

	public NewCustomerPage clickNewCustomerPageLink() throws InterruptedException {
		newCustomerLink.click();
		Thread.sleep(5000);
		return new NewCustomerPage();
	}

	@FindBy(linkText = "Edit Customer")
	WebElement editCustomerLink;

	public EditCustomerPage clickEditCustomerPageLink() throws InterruptedException {
		editCustomerLink.click();
		Thread.sleep(5000);
		return new EditCustomerPage();
	}

	@FindBy(linkText = "Delete Customer")
	WebElement deleteCustomerLink;

	public DeleteCustomerPage clickDeleteCustomerPageLink() throws InterruptedException {
		deleteCustomerLink.click();
		Thread.sleep(5000);
		return new DeleteCustomerPage();
	}

	@FindBy(linkText = "New Account")
	WebElement newAccountLink;

	public NewAccountPage clickNewAccountPageLink() throws InterruptedException {
		newAccountLink.click();
		Thread.sleep(5000);
		return new NewAccountPage();
	}

	@FindBy(linkText = "Edit Account")
	WebElement editAccountLink;

	public EditAccountPage clickEditAccountPageLink() throws InterruptedException {
		editAccountLink.click();
		Thread.sleep(5000);
		return new EditAccountPage();
	}

	@FindBy(linkText = "Delete Account")
	WebElement deleteAccountLink;

	public DeleteAccountPage clcikDeleteAccountPageLink() throws InterruptedException {
		deleteAccountLink.click();
		Thread.sleep(5000);
		return new DeleteAccountPage();
	}

	@FindBy(linkText = "Deposit")
	WebElement depositLink;

	public DepositPage clickDepositPageLink() throws InterruptedException {
		depositLink.click();
		Thread.sleep(5000);
		return new DepositPage();
	}

	@FindBy(linkText = "Withdrawal")
	WebElement withdrawalLink;

	public WithdrawalPage clickWithdrawalPageLink() throws InterruptedException {
		withdrawalLink.click();
		Thread.sleep(5000);
		return new WithdrawalPage();
	}

	@FindBy(linkText = "Fund Transfer")
	WebElement fundTransferLink;

	public FundTransferPage clickFundTransferPageLink() throws InterruptedException {
		fundTransferLink.click();
		Thread.sleep(5000);
		return new FundTransferPage();
	}

	@FindBy(linkText = "Change Password")
	WebElement changePasswordLink;

	public ChangePasswordPage clickChangePasswordPageLink() throws InterruptedException {
		changePasswordLink.click();
		Thread.sleep(5000);
		return new ChangePasswordPage();
	}

	@FindBy(linkText = "Balance Enquiry")
	WebElement balanceEnquiryLink;

	public BalanceEnquiryPage clickBalanceEnquiryPageLink() throws InterruptedException {
		balanceEnquiryLink.click();
		Thread.sleep(5000);
		return new BalanceEnquiryPage();
	}

	@FindBy(linkText = "Mini Statement")
	WebElement miniStatementLink;

	public MiniStatementPage clickMiniStatementPageLink() throws InterruptedException {
		miniStatementLink.click();
		Thread.sleep(5000);
		return new MiniStatementPage();
	}

	@FindBy(linkText = "Customised Statement")
	WebElement customisedStatementLink;

	public CustomisedStatementPage clickCustomisedStatementPageLink() throws InterruptedException {
		customisedStatementLink.click();
		Thread.sleep(5000);
		return new CustomisedStatementPage();
	}

	@FindBy(linkText = "Log out")
	WebElement logOutLink;

	public LogOutPage clickLogOutPageLink() throws InterruptedException {
		logOutLink.click();
		Thread.sleep(5000);
		switchToWindowAlert();
		manageAlert(AlertAction.ACCEPT);
		return new LogOutPage();
	}

}
