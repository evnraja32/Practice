package wrapper;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import util.ExtentReporter;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGWrapper extends ProjectWrapper{
	protected static String browser ;
	protected static String url;
	@BeforeSuite
	public void beforeSuite() {
		ExtentReporter.startResult();
	}

	@BeforeTest
	public void beforeTest() {
	}

	@BeforeMethod
	public void beforeMethod() {
		launchApp(browser, url);
		ExtentReporter.startResult();
		
	}

	@AfterMethod
	public void afterMethod() {
		closeTheBrowser();
		ExtentReporter.endResult();
	}

	@AfterTest
	public void afterTest() {
	}

	@AfterSuite
	public void afterSuite() {
	}
	
	
	@DataProvider(name="excelDataProvider")
	public Object[][] excelDataProvider() {
		return new Object[][] {
			new Object[] { 1, "a" },
			new Object[] { 2, "b" },
		};
	}
	
	@DataProvider(name="dataBaseExecutor")
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { 1, "a" },
			new Object[] { 2, "b" },
		};
	}
	
}
