package wrapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import util.ExtentReporter;
import util.TargetBrowser;

public class PageFactoryWrapper {

	protected static String browser;
	protected static String url;
	protected static RemoteWebDriver driver;
	protected static WebElement element;
	private static String parentWindow = null;
	private static Alert a = null;
	protected static Select select = null;

	// ===== Browser ===================
	public static void launchApp(String browser, String url) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		try {
			if (browser.equals(TargetBrowser.FIREFOX)) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver-0.10.0.exe");
				driver = new FirefoxDriver();
			} else if (browser.equals(TargetBrowser.CHROME)) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromeV54/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals(TargetBrowser.INTERNETEXPLORER)) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else if (browser.equals(TargetBrowser.EDGE)) {
				System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
			}

			driver.manage().window().maximize();
			waitTillPageloads();
			driver.get(url);

			ExtentReporter.reportStep(browser + " has initiated<br>Web Application: " + url + " successfully", "PASS");
		} catch (WebDriverException e) {
			e.printStackTrace();
			ExtentReporter.reportStep(
					"Failed to initiate Web Page: " + url + " through Browser : " + browser
							+ "<br>Plese find the details below:<br><p style=\"color:red;\">" + e.getMessage() + "</p>",
					"FATAL");
			// printException(e,"Unable to launch app");
		}
	}

	public static void waitTillPageloads() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public static void closeTheWindow() {
		driver.close();
	}

	public static void closeTheBrowser() {
		driver.quit();

	}

	// ===== Browser =====================

	// ===== finding elements ============

	public static void locateElementByID(String id) {
		try {
			element = driver.findElement(By.id(id));
			// element = new WebDriverWait(driver,
			// 5).until(ExpectedConditions.presenceOfElementLocated((By.id(id))));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find element by ID");
		}
	}

	public static void locateElementByName(String name) {
		try {
			element = driver.findElement(By.name(name));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find element by name");
		}
	}

	public static void locateElementByClassName(String className) {
		try {
			element = driver.findElement(By.className(className));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find element by class name");
		}
	}

	public static void locateElementByLinkText(String linkText) {
		try {
			element = driver.findElement(By.linkText(linkText));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find element by linkText");
		}
	}

	public static void locateElementByPartialLinkText(String partialLinkText) {
		try {
			element = driver.findElement(By.partialLinkText(partialLinkText));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find element by partialLink");
		}
	}

	public static void locateElementByXpath(String xpath) {
		try {
			element = driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find element by xpath");
		}
	}

	public static void locateElementByCssSelector(String cssSelector) {
		try {
			element = driver.findElement(By.cssSelector(cssSelector));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find element by css selector");
		}
	}

	public static void locateElementByTagName(String tagName) {
		try {
			element = driver.findElement(By.tagName(tagName));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find element by tagname");
		}
	}

	public static WebElement getWebElement() {
		return element;
	}

	public static void setWebElement(WebElement element) {
		ProjectWrapper.element = element;
	}

	public static List<WebElement> locateElementsByID(String id) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.id(id));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find elements by ID");
		}
		return elements;
	}

	public static List<WebElement> locateElementsByName(String name) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.name(name));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find elements by name");
		}
		return elements;
	}

	public static List<WebElement> locateElementsByClassName(String className) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.className(className));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find elements by class name");
		}
		return elements;
	}

	public static List<WebElement> locateElementsByLinkText(String linkText) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.linkText(linkText));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find elements by link text");
		}
		return elements;
	}

	public static List<WebElement> locateElementsByPartialLinkText(String partialLinkText) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.partialLinkText(partialLinkText));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find elements by partial Link Text");
		}
		return elements;
	}

	public static List<WebElement> locateElementsByCssSelector(String cssSelector) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.cssSelector(cssSelector));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find elements by Css Selector");
		}
		return elements;
	}

	public static List<WebElement> locateElementsByXpath(String xpath) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find elements by xpath");
		}
		return elements;
	}

	public static List<WebElement> locateElementsByTagName(String tagName) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.tagName(tagName));
		} catch (NoSuchElementException e) {
			printException(e, "Unable to find elements by TagName");
		}
		return elements;
	}

	// ====== finding elements ===========

	// ====== Browser Actions ============
	public static void sendKeysToWebElement(String keysToSend) {
		element.clear();
		element.sendKeys(keysToSend);
	}

	public static void clickOnElement() {
		element.click();
	}

	public static void selectDdElementByIndex(int targetElementIndex) {
		try {
			select = new Select(element);
			select.selectByIndex(targetElementIndex);
		} catch (NoSuchElementException e) {
			printException(e, "Cannot locate option with index : " + targetElementIndex);
		} catch (UnexpectedTagNameException e) {
			printException(e, "Tag Used doesn't belongs to Select");
		}
	}

	public static void selectDdElementByValue(String value) {
		try {
			select = new Select(element);
			select.selectByValue(value);
		} catch (NoSuchElementException e) {
			printException(e, "Cannot locate option with value : " + value);
		} catch (UnexpectedTagNameException e) {
			printException(e, "Tag Used doesn't belongs to Select");
		}
	}

	public static void selectDdElementByVisibleText(String visibleText) {
		try {
			select = new Select(element);
			select.selectByVisibleText(visibleText);
		} catch (NoSuchElementException e) {
			printException(e, "Cannot locate option with visibleText : " + visibleText);
		} catch (UnexpectedTagNameException e) {
			printException(e, "Tag Used doesn't belongs to Select");
		}
	}

	public static String getDdSelectedOption() {
		return select.getFirstSelectedOption().getText();
	}

	public static boolean verifyElementText(String targetText) {
		return element.getText().equals(targetText);
	}

	public static boolean verifyElementTextContains(String targetText) {
		return element.getText().contains(targetText);
	}

	public static boolean verifyUrl(String targetURL) {
		return driver.getCurrentUrl().equals(targetURL);
	}

	public static boolean verifyWebElementDisplay() {
		return element.isDisplayed();
	}

	public static boolean verifyWindowTitle(String targetTitle) {
		return driver.getTitle().equals(targetTitle);
	}

	public static String currentWindowTitle() {
		return driver.getTitle();
	}

	public static String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}
	// ====== Browser Actions ============

	// ====== Windows Handling ===========

	public static Set<String> prepareAllWindowHandlers() {
		Set<String> windowHandlers = null;
		try {
			parentWindow = driver.getWindowHandle();
			windowHandlers = driver.getWindowHandles();
		} catch (NoSuchWindowException e) {
			printException(e, "Exception at getLast Window Method" + e.getMessage());
		}
		return windowHandlers;
	}

	public static String getParentWindowHandle() {
		return parentWindow;
	}

	// - switchToPrimaryWindow
	public static RemoteWebDriver switchToPrimaryWindow() {
		return (RemoteWebDriver) driver.switchTo().window(parentWindow);
	}

	// - switchToLastWindow
	public static RemoteWebDriver switchToLastWindow() {

		try {
			for (String eachWindow : prepareAllWindowHandlers()) { // for each
																	// window in
																	// window
																	// handles
				driver.switchTo().window(eachWindow); // we are Switching to
														// respective window
			}
		} catch (NoSuchWindowException e) {
			printException(e, "Exception at getLast Window Method" + e.getMessage());
		}
		return driver;
	}

	// ====== Windows Handling ===========

	// ====== Handling Frames =============

	public static RemoteWebDriver switchToFrameByNameOrID(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {

			printException(e, "The given element is neither an IFRAME nor a FRAME element");

		} catch (StaleElementReferenceException e) {
			printException(e, "The WebElement has gone stale.");
		}

		return driver;
	}

	public static RemoteWebDriver switchToFrameByindex(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {

			printException(e, "The given element is neither an IFRAME nor a FRAME element");

		} catch (StaleElementReferenceException e) {
			printException(e, "The WebElement has gone stale.");
		}

		return driver;
	}

	public static RemoteWebDriver switchToFrameByNameOrID(WebElement frameElement) {

		try {
			driver.switchTo().frame(frameElement);
		} catch (NoSuchFrameException e) {

			printException(e, "The given element is neither an IFRAME nor a FRAME element");

		} catch (StaleElementReferenceException e) {
			printException(e, "The WebElement has gone stale.");
		}

		return driver;
	}

	public static RemoteWebDriver switchToDefaultContent() {

		return (RemoteWebDriver) driver.switchTo().defaultContent();
	}

	// ====== Handling Frames =============

	// ====== Handling Alerts ============

	public static void switchToWindowAlert() {
		try {
			a = driver.switchTo().alert();
		} catch (NoAlertPresentException e) {
			printException(e, "No alert on the screen");
		}
		// return a.getText();
	}

	public static void manageAlert(String action) {
		if (action.equalsIgnoreCase("accept")) {
			a.accept();
		} else if (action.equalsIgnoreCase("dismiss")) {
			a.dismiss();
		}
	}

	public static void enterAlertText(String keysToSend) {
		a.sendKeys(keysToSend);
	}

	// ====== Handling Alerts ============

	public static void printException(Throwable e, String errorMessage) {

		System.out.println(errorMessage);
		e.printStackTrace();

	}

	public static String takeScreenShot(String imageName) {
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File("./output/reports/images/" + imageName + ".jpg"));

		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "H://Practice/output/reports/images/" + imageName + ".jpg";

	}

}