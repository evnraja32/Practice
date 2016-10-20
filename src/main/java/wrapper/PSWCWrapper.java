package wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.Platform;
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
import org.openqa.selenium.support.ui.Select;

import util.ExtentReporter;

public class PSWCWrapper {

	protected static RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,sHubUrl,sHubPort;

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

	public WebElement getWebElementBy(String locatorType, String locatorValue){
		try{
			element = driver.findElement(by(locatorType, locatorValue));
		}catch(NoSuchElementException e ){
			printException(e, "Unable o find the webElement Using: "+locatorType+" && locator Value: "+locatorValue);
		}catch(StaleElementReferenceException se){
			printException(se, "Unable o find the webElement Using: "+locatorType+" && locator Value: "+locatorValue);
		}	return element;
	}

	public List<WebElement> getWebElementsListBy(String locatorType, String locatorValue){
		List<WebElement> elements = null;
		try{
			elements = driver.findElements(by(locatorType, locatorValue));
		}catch(NoSuchElementException e ){
			printException(e, "Unable o find the webElements Using: "+locatorType+" && locator Value: "+locatorValue);
		}catch(StaleElementReferenceException se){
			printException(se, "Unable o find the webElements Using: "+locatorType+" && locator Value: "+locatorValue);
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
			printException(e, "Error at sendKeysToWebElement");
			reportStatus("The data : "+keysToSend+" has not Successfully entered", "FAIL");
		}
		return flag;
	}

	public boolean clickOnElement(){
		boolean flag  = false;
		try {
			element.click();
			flag = true;
			reportStatus("The element : "+element.getText()+" has Clicked Successfully", "PASS");
		} catch (Exception e){
			printException(e, "Error at clickOnElement Method");
			reportStatus("he element : "+element.getText()+" has not Successfully Clicked", "FAIL");
		}
		return flag;
	}

	public boolean mouseOverByLinkText(String linkName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(element).build().perform();
			reportStatus("The mouse over by link : "+linkName+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			reportStatus("The mouse over by link : "+linkName+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	public boolean selectDdElementByIndex(int targetElementIndex){
		boolean flag = false;
		try {
			select = new Select(element);
			select.selectByIndex(targetElementIndex);
			flag = true;
			reportStatus("The element is selected with index :"+targetElementIndex, "PASS");
		} catch (Exception e){
			printException(e, "Error at selectDdElementByIndex");
			reportStatus("The value: "+targetElementIndex+" could not be selected.", "FAIL");
		}
		return flag;
	}

	public boolean selectDdElementByValue(String selectValue){
		boolean flag  = false;
		try {
			select = new Select(element);
			select.selectByValue(selectValue);
			flag = true;
			reportStatus("The element is selected with value :"+selectValue, "PASS");
		} catch (Exception e){
			printException(e, "Error at selectDdElementByValue");
			reportStatus("The value: "+selectValue+" could not be selected.", "FAIL");
		}
		return flag;
	}

	public boolean selectDdElementByVisibleText(String selectValue){
		boolean flag  = false;
		try {
			select = new Select(element);
			select.selectByVisibleText(selectValue);
			flag = true;
			reportStatus("The element is selected with value :"+selectValue, "PASS");
		} catch (Exception e){
			printException(e, "Error at selectDdElementByVisibleText");
			reportStatus("The value: "+selectValue+" could not be selected.", "FAIL");
		}
		return flag;
	}

	public String getDdSelectedOption(){
		return select.getFirstSelectedOption().getText();
	}

	public boolean verifyElementText(String targetText) {
		boolean bReturn = false;
		String actualText = element.getText();
		if (actualText.equalsIgnoreCase(targetText)){
			reportStatus("The text: "+actualText+" matches with the value :"+targetText, "PASS");
			bReturn = true;
		}else{
			reportStatus("The text: "+actualText+" matches with the value :"+targetText,  "FAIL");
		}
		return bReturn;
	}

	public boolean verifyElementTextExactMatch(String targetText) {
		boolean bReturn = false;
		String actualText = element.getText();
		if (actualText.equals(targetText)){
			reportStatus("The text: "+actualText+" matches with the value :"+targetText, "PASS");
			bReturn = true;
		}else{
			reportStatus("The text: "+actualText+" matches with the value :"+targetText,  "FAIL");
		}
		return bReturn;
	}

	public boolean verifyElementTextPartialMatch(String targetText) {
		boolean bReturn = false;
		String actualText = element.getText();
		if (actualText.contains(targetText)){
			reportStatus("The text: "+actualText+" contains the value :"+targetText, "PASS");
			bReturn = true;
		}else{
			reportStatus("The text: "+actualText+" contains the value :"+targetText,  "FAIL");
		}
		return bReturn;
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

	public boolean verifyWebElementDisplay(){
		boolean flag = element.isDisplayed();
		if(flag)
			reportStatus("Element has displayed",  "PASS");
		else
			reportStatus("Element has not displayed",  "FAIL");

		return flag; 
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
			printException(e,"Exception at getLast Window Method"+e.getMessage());
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
			printException(e, "The WebElement has gone stale.");
			reportStatus("Swithced to Frame by NameOrId Failed", "FAIL");
		}

		return driver;
	}

	public RemoteWebDriver switchToFrameByindex(int index){
		try{
			driver.switchTo().frame(index);
			reportStatus("Switched to Frame by Index", "PASS");
		} catch (Exception e){
			printException(e, "The WebElement has gone stale.");
			reportStatus("Swithced to Frame by Index Failed", "FAIL");
		}
		return driver;
	}

	public RemoteWebDriver switchToFrameByWebElement(WebElement frameElement){
		try {
			driver.switchTo().frame(frameElement);
			reportStatus("Switched to Frame by WebElement", "PASS");
		} catch (Exception e){
			printException(e, "The WebElement has gone stale.");
			reportStatus("Swithced to Frame by WebElement Failed", "FAIL");
		}
		return driver;
	}

	public RemoteWebDriver switchToDefaultContent(){
		try {
			driver = (RemoteWebDriver) driver.switchTo().defaultContent();
			reportStatus("Switched to Default Content", "PASS");
		} catch (Exception e){
			printException(e, "The WebElement has gone stale.");
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
			printException(e, "No alert on the screen");
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
			printException(e, "Error at sendKeysToWebElement");
			reportStatus("The data : "+keysToSend+" has not Successfully entered", "FAIL");
		}
		return flag;
	}

	//====== Handling Alerts ============

	//====== Handling Excel Files =======

	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;
	private File excelFile = null;
	private FileInputStream fis = null;
	private FileOutputStream fout = null;

	public void prepareExcelSheet(String fileName,String sheetName){
		excelFile = new File("./data/"+fileName+".xlsx");
		try{
			fis = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);

		}catch(IOException e){
			printException(e, "Error in excel book");
		}
	}

	public String readExcel(int rowIndex, int colnum) 
	{
		row = sheet.getRow(rowIndex);
		cell = row.getCell(colnum);
		return cell.getStringCellValue();
	}

	public void appendDataAt(int cellIndex,String data){
		try{
			sheet.createRow(sheet.getLastRowNum()+1).createCell(cellIndex).setCellValue(data);
			fout = new FileOutputStream(excelFile);
		}
		catch(Exception e){
			printException(e, "Error in appending to excel method");
		}
	}

	public XSSFWorkbook createWorkBook(String fileName) {
		try{
			fout = new FileOutputStream(new File("./data/"+fileName+".xlsx"));
			workbook = new XSSFWorkbook();
		}catch(Exception e){
			printException(e, "Work Book Creation Failed");
		} 
		return workbook;
	}

	public XSSFSheet createWorkSheet(String sheetName){
		try{
			sheet = workbook.createSheet(sheetName);
		}catch(Exception e){
			printException(e, "Work Sheet Creation Failed");
		} 
		return sheet;
	}

	public XSSFRow createRowAt(int rowNum){
		try{
			row = sheet.createRow(rowNum);
		}catch(Exception e){
			printException(e, "Work Sheet Creation Failed in creating Row");
		} 
		return row;
	}

	public void setCellValueAt(int cellNum, String cellValue){
		try{
			row.createCell(cellNum).setCellValue(cellValue);
		}catch(Exception e){
			printException(e, "Work Sheet Creation Failed in creating cell value");
		} 
	}

	public void commitChangesToExcel(){
		try {
			workbook.write(fout);

			fout.close();
			workbook.close();

		} catch (IOException e) {
			printException(e, "Writing to excel failed");
		}
	}


	//====== Handling Excel Files =======

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
