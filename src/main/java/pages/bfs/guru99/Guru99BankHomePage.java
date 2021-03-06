package pages.bfs.guru99;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import util.ExtentReporter;
import wrapper.PageFactoryWrapper;

public class Guru99BankHomePage extends PageFactoryWrapper {

	public Guru99BankHomePage(){
		String expTitle = "Guru99 Bank Home Page";
		if(!verifyWindowTitle(expTitle)){
			ExtentReporter.reportStep("<p style=\"color:red\">Expected Page: "+expTitle+"<br>"
					+ "Actual Page: "+currentWindowTitle()+"</p>","FAIL");
		}else{
			PageFactory.initElements(driver, this);
			ExtentReporter.reportStep("<p style=\"color:green\">\""+expTitle+"\" Page Landed</p>","PASS");
		}
	}


	@FindBy(how=How.CSS,using="input[name='uid']")
	private WebElement loginTF ;

	public Guru99BankHomePage enterUserName(String userName){
		loginTF.sendKeys(userName);
		ExtentReporter.reportStep("Entered Username: "+userName,"PASS");
		return new Guru99BankHomePage();
	}

	@FindBy(how=How.CSS,using="input[name='password']")
	private WebElement passwordTF ;

	public Guru99BankHomePage enterPassword(String password){
		passwordTF.clear();
		passwordTF.sendKeys(password);
		ExtentReporter.reportStep("Entered Password: "+password,"PASS");
		return new Guru99BankHomePage();
	}

	@FindBy(how=How.CSS,using="input[name='btnLogin']")
	private WebElement loginBTN ;

	public ManagerHomePage clickLoginBTN() throws InterruptedException{
		loginBTN.click();
		Thread.sleep(5000);		
		if(switchToWindowAlert()){
			ExtentReporter.reportStep("Alert is getting displayed\n"+getAlertText(),"INFO");
			throw new RuntimeException();
		}else{
			ExtentReporter.reportStep("Successfully Pressed Login Button","PASS");
			return new ManagerHomePage();
		}
	}

	@FindBy(how=How.CSS,using="input[name='btnReset']")
	private WebElement resetBTN ;

	public Guru99BankHomePage clickResetBTN(){
		resetBTN.click();
		ExtentReporter.reportStep("Successfully Clicked Reset Button","PASS");
		return new Guru99BankHomePage();
	}


}
