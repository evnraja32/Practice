package keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.ExtentReporter;

public class BaseClass {
	protected WebDriver driver = null;
	protected WebElement element = null;

	public void goToURL(String browser, String url) {
		try {
			switch (browser.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver-0.10.0.exe");
				driver = new FirefoxDriver();
				break;
			case "edge":
				System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
				break;
			}

			ExtentReporter.reportStep("browser open::" + browser, "INFO");

			driver.get(url);
			ExtentReporter.reportStep("Navigate to URL::" + url, "PASS");
		} catch (Exception e) {
			ExtentReporter.reportStep(e.getMessage(), "FAIL");
		}
	}

	public void locateElement(String locatorType, String locatorValue) {
		try{
		By by = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			by = By.id(locatorValue);
			break;
		case "name":
			by = By.name(locatorValue);
			break;
		case "tagName":
			by = By.tagName(locatorValue);
			break;
		case "className":
			by = By.className(locatorValue);
			break;
		case "linkText":
			by = By.linkText(locatorValue);
			break;
		case "partialLinkText":
			by = By.partialLinkText(locatorValue);
			break;
		case "xpath":
			by = By.xpath(locatorValue);
			break;

		case "cssSelector":
			by = By.cssSelector(locatorValue);
			break;
		}
		element = driver.findElement(by);
		ExtentReporter.reportStep("Element has located ", "INFO");
		} catch (Exception e) {
			ExtentReporter.reportStep(e.getMessage(), "FAIL");
		}
	}

	public void typeText(String textType) {
		try{
		element.sendKeys(textType);
		ExtentReporter.reportStep("following text has entered::" + textType, "INFO");
		} catch (Exception e) {
			ExtentReporter.reportStep(e.getMessage(), "FAIL");
		}
	}

	public void click() {
		try{
		element.click();
		ExtentReporter.reportStep("clicked operation performed", "INFO");
		} catch (Exception e) {
			ExtentReporter.reportStep(e.getMessage(), "FAIL");
		}
	}

	public void quitBrowser() {
		try{
		driver.quit();
		ExtentReporter.reportStep("Browser closed", "PASS");
		ExtentReporter.endResult();
		} catch (Exception e) {
			ExtentReporter.reportStep(e.getMessage(), "FAIL");
		}
	}

}
