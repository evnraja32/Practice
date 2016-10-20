package wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.ExtentReporter;

public class PSWCWrapper {

	protected static RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,sHubUrl,sHubPort;
	private static final int DEFAULT_TIME_OUT = 30; 

	private WebElement element;
	public String parentWindow = null;
	private Alert a = null;
	Select select = null;

	public PSWCWrapper() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			printException("Unable to find Config properties file\nError Message: "+e.getMessage());
		} catch (IOException e) {
			printException("Unable to load Config properties file\nError Message: "+e.getMessage());
		}
	}

	//===== Browser ===================
	public void loadObjects() throws FileNotFoundException, IOException{
		try{
			prop = new Properties();
			prop.load(new FileInputStream(new File("./object.properties")));
		} catch (FileNotFoundException e) {
			printException("Unable to find Object properties file\nError Message: "+e.getMessage());
		} catch (IOException e) {
			printException("Unable to load Object properties file\nError Message: "+e.getMessage());
		}
	}

	public boolean launchApp(String browser){
		boolean bReturn = false;
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			//			dc.setBrowserName(browser);
			//			dc.setPlatform(Platform.WINDOWS);
			dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			/*if(browser.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
			}*/

			switch(browser.toLowerCase().trim()){

			case "firefox":
				System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
				driver = new FirefoxDriver(dc);
				break;

			case "chrome":
				System.setProperty("webdriver.chorme.driver", "./lib/chromedriver.exe");
				driver= new ChromeDriver(dc);
				break;

			case "ie":
				System.setProperty("webdriver.ie.driver", "./lib/IEDriverServer.exe");
				driver = new InternetExplorerDriver(dc);
				break;

			case "edge":
				System.setProperty("webdriver.edge.driver", "./lib/MicrosoftWebDriver.exe");
				driver = new EdgeDriver(dc);
				break;

			}

			driver.get(sUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			parentWindow = driver.getWindowHandle();
			reportStatus("The browser:" + browser + " launched successfully", "PASS");
			bReturn = true;

		}catch(Exception e) {
			printException("Unable to open browser\nError Message: "+e.getMessage());
			reportStatus("The browser:" + browser + " could not be launched", "FAIL");
		}
		return bReturn;
	}

	public void browserWait(int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void closeTheWindow() {
		driver.close();
	}

	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			printException("Unable to close the browser.\nError Message: "+e.getMessage());
			reportStatus("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.", "FAIL");
		}

	}

	//===== Browser ===============================

	//===== Finding Elements ======================

	private By by(String locatorType, String locatorValue) throws NoSuchElementException, StaleElementReferenceException{
		By by = null;

		if(locatorType.equals("id"))
			by = By.id(locatorValue);	
		else if(locatorType.equals("classname"))
			by = By.className(locatorValue);		
		else if(locatorType.equals("linktext"))
			by = By.linkText(locatorValue);		
		else if(locatorType.equals("partiallinktext"))
			by = By.partialLinkText(locatorValue);	
		else if(locatorType.equals("name"))
			by = By.name(locatorValue);	
		else if(locatorType.equals("tagname"))
			by = By.tagName(locatorValue);	
		else if(locatorType.equals("xpath"))
			by = By.xpath(locatorValue);	
		else if(locatorType.equals("cssselector"))
			by = By.cssSelector(locatorValue);
		else
			reportStatus("Unable to find the \nElement Type : "+locatorType+"\nElement Value : "+locatorValue, "FAIL");
		reportStatus("Found the Element \nElement Type : "+locatorType+"\nElement Value : "+locatorValue, "PASS");

		return by;
	}

	public WebElement locateWebElementBy(String locatorType, String locatorValue){
		try{
			element = driver.findElement(by(locatorType, locatorValue));
		}catch(NoSuchElementException e ){
			printException("Unable to find the webElement Using: "+locatorType+" && locator Value: "+locatorValue+"\nError Message: "+e.getMessage());
		}catch(StaleElementReferenceException e){
			printException("Unable o find the webElement Using: "+locatorType+" && locator Value: "+locatorValue+"\nError Message: "+e.getMessage());
		}	return element;
	}

	public List<WebElement> locateWebElementsListBy(String locatorType, String locatorValue){
		List<WebElement> elements = null;
		try{
			elements = driver.findElements(by(locatorType, locatorValue));
		}catch(NoSuchElementException e ){
			printException("Unable to find the webElements Using: "+locatorType+" && locator Value: "+locatorValue+"\nError Message: "+e.getMessage());
		}catch(StaleElementReferenceException e){
			printException("Unable to find the webElements Using: "+locatorType+" && locator Value: "+locatorValue+"\nError Message: "+e.getMessage());
		}

		return elements;
	}

	public WebElement getWebElement(){
		return element;
	}
	//===================================== Finding Elements ======================

	//====== Browser Actions ============
	public boolean sendKeysToWebElement(String keysToSend){
		boolean flag  = false;
		try {
			element.clear();
			element.sendKeys(keysToSend);
			flag = true;
			reportStatus("The data : "+keysToSend+" has Successfully entered", "PASS");
		} catch (Exception e){
			printException("Error at sendKeysToWebElement"+"\nError Message: "+e.getMessage());
			reportStatus("The data : "+keysToSend+" has not Successfully entered", "FAIL");
		}
		return flag;
	}

	public boolean clickOnElement(){
		boolean flag  = false;
		try {
			new WebDriverWait(driver, DEFAULT_TIME_OUT).until(ExpectedConditions.elementToBeClickable(element)).click();
			flag = true;
			reportStatus("The element : "+element.getText()+" has Clicked Successfully", "PASS");
		} catch (Exception e){
			printException("Error at clickOnElement Method"+"\nError Message: "+e.getMessage());
			reportStatus("he element : "+element.getText()+" has not Successfully Clicked", "FAIL");
		}
		return flag;
	}

	public boolean mouseOverToWebElement(WebElement targetElement) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(targetElement).build().perform();
			reportStatus("The mouse has moved onto "+targetElement.getText(), "PASS");

			bReturn = true;

		} catch (Exception e) {
			reportStatus("Fail to perform mouse over onto "+targetElement.getText()+"\nError Message: "+e.getMessage(), "FAIL");
		}
		return bReturn;
	}

	private Select getSelect(){
		if(new WebDriverWait(driver, DEFAULT_TIME_OUT).until(ExpectedConditions.elementToBeSelected(element))){
			select = new Select(element);
		}
		else{
			throw new RuntimeException("Unable to load Drop Down");	
		}

		return select;
	}

	public boolean selectDdElementByIndex(int targetElementIndex){
		boolean flag = false;
		try {
			getSelect().selectByIndex(targetElementIndex);
			flag = true;
			reportStatus("The element is selected with index :"+targetElementIndex+"\nSelected Value: "+getDdSelectedOption(), "PASS");
		} catch (Exception e){
			printException("Error at selectDdElementByIndex"+"\nError Message: "+e.getMessage());
			reportStatus("The value index: "+targetElementIndex+" could not be selected.", "FAIL");
		}
		return flag;
	}

	public boolean selectDdElementByValue(String selectValue){
		boolean flag  = false;
		try {
			getSelect().selectByValue(selectValue);
			flag = true;
			reportStatus("The element is selected with index :"+selectValue+"\nSelected Value: "+getDdSelectedOption(), "PASS");
		} catch (Exception e){
			printException("Error at selectDdElementByIndex"+"\nError Message: "+e.getMessage());
			reportStatus("The value index: "+selectValue+" could not be selected.", "FAIL");
		}
		return flag;
	}

	public boolean selectDdElementByVisibleText(String selectValue){
		boolean flag  = false;
		try {
			getSelect().selectByVisibleText(selectValue);
			flag = true;
			reportStatus("The element is selected with index :"+selectValue+"\nSelected Value: "+getDdSelectedOption(), "PASS");
		} catch (Exception e){
			printException("Error at selectDdElementByIndex"+"\nError Message: "+e.getMessage());
			reportStatus("The value index: "+selectValue+" could not be selected.", "FAIL");
		}
		return flag;
	}

	public String getDdSelectedOption(){
		return select.getFirstSelectedOption().getText();
	}

	public boolean verifyUrl(String targetURL) {
		boolean bReturn = false;
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.contains(targetURL)){
			reportStatus("URL Mathced\nActual URL: \n"+actualUrl+"\nTarget URL :\n"+targetURL, "PASS");
			bReturn = true;
		}else{
			reportStatus("URL doesn't matches\nActual URL: \n"+actualUrl+"\nTarget URL :\n"+targetURL,  "FAIL");
		}
		return bReturn;
	}

	public boolean verifyTitle(String targetTitle) {
		boolean bReturn = false;
		try{
			if (driver.getTitle().equals(targetTitle)){
				reportStatus("The title of the page matches with the value :"+targetTitle, "PASS");
				bReturn = true;
			}else
				reportStatus("The title of the page:"+driver.getTitle()+" did not match with the value :"+targetTitle, "SUCCESS");

		}catch (Exception e) {
			reportStatus("The title did not match", "FAIL");
		}

		return bReturn;
	}

	public String getCurrentPageURL(){
		return driver.getCurrentUrl();
	}
	//====== Browser Actions ============

	//====== Windows Handling ===========

	public Set<String> prepareAllWindowHandlers(){
		Set<String> windowHandlers = null;
		try{
			parentWindow = driver.getWindowHandle();
			windowHandlers = driver.getWindowHandles();
			reportStatus("Window Handles identified successfully", "PASS");
		}catch(NoSuchWindowException e){
			printException("Exception at getLast Window Method"+e.getMessage());
			reportStatus("Window Handles identified Failed", "FAIL");
		}
		return windowHandlers;
	}

	public String getParentWindowHandle(){
		return parentWindow;
	}

	//- switchToPrimaryWindow
	public RemoteWebDriver switchToPrimaryWindow() {
		try{
			driver = (RemoteWebDriver) driver.switchTo().window(parentWindow);
			reportStatus("Window Switched to Primary Window"+parentWindow, "PASS");
		}catch(NoSuchWindowException e){
			reportStatus("Failed in switching to Primary Window", "FAIL");
		}
		return driver; 
	}
	public RemoteWebDriver switchToLastWindow() {
		try{
			for( String eachWindow : prepareAllWindowHandlers()){ //for each window in window handles
				if(!eachWindow.equals(parentWindow))
					driver.switchTo().window(eachWindow);	 //we are Switching to respective window
			}
			reportStatus("Window Switched to Last Window", "PASS");
		}catch(NoSuchWindowException e){
			reportStatus("Failed in switching to Last Window", "FAIL");
		}
		return driver;
	}

	//====== Windows Handling ===========

	//====== Handling Frames =============

	public RemoteWebDriver switchToFrameByNameOrID(String nameOrId){
		try{
			driver.switchTo().frame(nameOrId);
			reportStatus("Switched to Frame by NameOrId", "PASS");
		} catch (Exception e){
			printException("Swithced to Frame by NameOrId Failed\nError Message: "+e.getMessage());
			reportStatus("Swithced to Frame by NameOrId Failed", "FAIL");
		}

		return driver;
	}

	public RemoteWebDriver switchToFrameByindex(int index){
		try{
			driver.switchTo().frame(index);
			reportStatus("Switched to Frame by Index", "PASS");
		} catch (Exception e){
			printException("Swithced to Frame by index Failed\nError Message: "+e.getMessage());
			reportStatus("Swithced to Frame by Index Failed", "FAIL");
		}
		return driver;
	}

	public RemoteWebDriver switchToFrameByWebElement(WebElement frameElement){
		try {
			driver.switchTo().frame(frameElement);
			reportStatus("Switched to Frame by WebElement", "PASS");
		} catch (Exception e){
			printException("Swithced to Frame by WebElement Failed\nError Message: "+e.getMessage());
			reportStatus("Swithced to Frame by WebElement Failed", "FAIL");
		}
		return driver;
	}

	public RemoteWebDriver switchToDefaultContent(){
		try {
			driver = (RemoteWebDriver) driver.switchTo().defaultContent();
			reportStatus("Switched to Default Content", "PASS");
		} catch (Exception e){
			printException("Swithced to Default Content Failed\nError Message: "+e.getMessage());
			reportStatus("Swithced to Default Content Failed", "FAIL");
		}

		return driver;
	}

	//====== Handling Frames =============

	//====== Handling Alerts ============

	public String switchToWindowAlert(){
		try{
			a = driver.switchTo().alert();
			reportStatus("Alert is displayed", "PASS");
		}
		catch(NoAlertPresentException e)
		{
			printException("No alert on the screen\nError Message: "+e.getMessage());
			reportStatus("No Such Alert is displayed", "FAIL");
		}
		return a.getText();
	}

	public boolean manageAlert(String action){
		boolean flag = false;
		if(action.equalsIgnoreCase("accept")){
			a.accept();
			flag = true;
			reportStatus("Switched to Default Content", "PASS");
		}
		else if(action.equalsIgnoreCase("dismiss")){
			a.dismiss();
			flag = true;
			reportStatus("Switched to Default Content", "PASS");
		}
		return flag;
	}

	public boolean enterAlertText(String keysToSend){
		boolean flag  = false;
		try {
			a.sendKeys(keysToSend);
			flag = true;
			reportStatus("The data : "+keysToSend+" has Successfully entered", "PASS");
		} catch (Exception e){
			printException("Error at sendKeysToWebElement inside alert\nError Message: "+e.getMessage());
			reportStatus("The data : "+keysToSend+" has not Successfully entered", "FAIL");
		}
		return flag;
	}

	//====== Handling Alerts ============

	//====== Exception Handles ==========

	public  void  printException(String errorMessage) {
		System.err.println(errorMessage);
		//		System.exit(-1);

	}

	public void reportStatus(String desc,String status){
		ExtentReporter.reportStep(desc, status.toUpperCase());
	}

	//====== Exception Handles ==========


}
