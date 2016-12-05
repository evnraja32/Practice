package pages.bfs.guru99;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ExtentReporter;
import wrapper.PageFactoryWrapper;

public class BalanceEnquiryPage extends PageFactoryWrapper{

	public BalanceEnquiryPage(){
		String expTitle = "Guru99 Bank Balance Enquiry Page";
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
	
	@FindBy(css="input[type='submit']")
	WebElement submitBTN;
	public BalanceEnquiryPage pressSubmitBTN(String accountNo){
		submitBTN.click();
		return  this;
	}
	
	@FindBy(css="input[type='reset']")
	WebElement resetBTN;
	public BalanceEnquiryPage pressResetBTN(String accountNo){
		resetBTN.click();
		return  this;
	}
	
	@FindBy(linkText="Home")
	WebElement homeLink;
	public ManagerHomePage clickHomeLink(String accountNo){
		homeLink.click();
		return  new ManagerHomePage();
	}
	
	@FindBy(css="input[type='text']")
	WebElement accountNoTF;
	public BalanceEnquiryPage enterAccountNumber(String accountNo){
		accountNoTF.clear();
		accountNoTF.sendKeys(accountNo);
		return  this;
	}
	
	
}
