package pages.bfs.guru99;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Factory;

import util.ExtentReporter;
import util.TargetBrowser;
import wrapper.PageFactoryWrapper;

public class ManagersMenu extends PageFactoryWrapper {

	public ManagersMenu() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String testCaseName = "TC025 Home Launch HomePage";
		String testCaseDesc = "Verify Launching Bank Home Page";
		browser = TargetBrowser.FIREFOX;
		url = "http://demo.guru99.com/V4";

		ExtentReporter.startResult();
		ExtentReporter.startTestCase(testCaseName, testCaseDesc);

		launchApp(browser, url); 
		try {
			new Guru99BankHomePage()
			.enterUserName("mngr55367")
			.enterPassword("EbaqYma")
			.clickLoginBTN();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(WebElement ele : locateElementsByTagName("a")){
			System.out.println(ele.getText());
		}
	}


	@FindBy(linkText="Manager")
	WebElement managerLink;
	public ManagerHomePage clickManagerPageLink(){
		managerLink.click();
		return new ManagerHomePage();
	}

	@FindBy(linkText="New Customer")
	WebElement newCustomerLink;
	public NewCustomerPage clickNewCustomerPageLink(){
		newCustomerLink.click();
		return new NewCustomerPage();
	}

	@FindBy(linkText="Edit Customer")
	WebElement editCustomerLink;
	public EditCustomerPage clickEditCustomerPageLink(){
		editCustomerLink.click();
		return new EditCustomerPage();
	}

	@FindBy(linkText="Delete Customer")
	WebElement deleteCustomerLink;
	public DeleteCustomerPage clickDeleteCustomerPageLink(){
		deleteCustomerLink.click();
		return new DeleteCustomerPage();
	}

	@FindBy(linkText="New Account")
	WebElement newAccountLink;
	public NewAccountPage clickNewAccountPageLink(){
		newAccountLink.click();
		return new NewAccountPage();
	}

	@FindBy(linkText="Edit Account")
	WebElement editAccountLink;
	public EditAccountPage clickEditAccountPageLink(){
		editAccountLink.click();
		return new EditAccountPage();
	}

	@FindBy(linkText="Delete Account")
	WebElement deleteAccountLink;
	public DeleteAccountPage clcikDeleteAccountPageLink(){
		deleteAccountLink.click();
		return new DeleteAccountPage();
	}

	@FindBy(linkText="Deposit")
	WebElement depositLink;
	public DepositPage clickDepositPageLink(){
		depositLink.click();
		return new DepositPage();
	}

	@FindBy(linkText="Withdrawal")
	WebElement withdrawalLink;
	public WithdrawalPage clickWithdrawalPageLink(){
		withdrawalLink.click();
		return new WithdrawalPage();
	}

	@FindBy(linkText="Fund Transfer")
	WebElement fundTransferLink;
	public FundTransferPage clickFundTransferPageLink(){
		fundTransferLink.click();
		return new FundTransferPage();
	}

	@FindBy(linkText="Change Password")
	WebElement changePasswordLink;
	public ChangePasswordPage clickChangePasswordPageLink(){
		changePasswordLink.click();
		return new ChangePasswordPage();
	}

	@FindBy(linkText="Balance Enquiry")
	WebElement balanceEnquiryLink;
	public BalanceEnquiryPage clickBalanceEnquiryPageLink(){
		balanceEnquiryLink.click();
		return new BalanceEnquiryPage();
	}

	@FindBy(linkText="Mini Statement")
	WebElement miniStatementLink;
	public MiniStatementPage clickMiniStatementPageLink(){
		miniStatementLink.click();
		return new MiniStatementPage();
	}

	@FindBy(linkText="Customised Statement")
	WebElement customisedStatementLink;
	public CustomisedStatementPage clickCustomisedStatementPageLink(){
		newCustomerLink.click();
		return new CustomisedStatementPage();
	}

	@FindBy(linkText="Log out")
	WebElement logOutLink;
	public LogOutPage gotoLogOutPage(){
		logOutLink.click();
		return new LogOutPage();
	}


}
